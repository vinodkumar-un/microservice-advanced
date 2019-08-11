package com.brownfield.pss.checkin.component;

import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.stereotype.Service;

import com.brownfield.pss.checkin.controller.Sender;
import com.brownfield.pss.checkin.entity.CheckInRecord;
import com.brownfield.pss.checkin.repository.CheckinRepository;

@Configuration
class AppConfig {
	@LoadBalanced
	@Bean
	public OAuth2RestTemplate restTemplate() {
		ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
		resource.setUsername("adolfo");
		resource.setPassword("123");
		resource.setAccessTokenUri("http://localhost:9090/oauth/token");
		resource.setClientId("clientapp");
		resource.setClientSecret("123456");
		resource.setGrantType("password");
		resource.setScope(Arrays.asList(new String[] { "read_profile"}));
		DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resource, clientContext);
		System.out.println("Access Token: " + restTemplate.getAccessToken());
		return restTemplate;
	}
}


@Service
public class CheckinComponent {
	private static final Logger logger = LoggerFactory.getLogger(CheckinComponent.class);

	//private static final String bookingURL = "http://BOOKING-SERVICE/booking";

	private static final String bookingURL = "http://common-apigateway/api/booking-path/booking";
	
	@Autowired
	private OAuth2RestTemplate restTemplate; // Added by Ramesh

	CheckinRepository checkinRepository;
	Sender sender;

	@Autowired
	CheckinComponent(CheckinRepository checkinRepository, Sender sender) {
		this.checkinRepository = checkinRepository;
		this.sender = sender;
		//this.restTemplate = new RestTemplate(); // Added by Ramesh
	}

	public long checkIn(CheckInRecord checkIn) {
		// Added by Ramesh K
		long bookingId = checkIn.getBookingId();
		BookingRecord bookingRecord = null;
		try {
			logger.info("calling booking to get booking information for booking id " + bookingId);
			// call booking to get know whether booking was done or not
			bookingRecord = restTemplate.getForObject(bookingURL + "/get/" + bookingId, BookingRecord.class);

			if (bookingRecord != null) { // booking existed
				if (bookingRecord.getStatus().equals(BookingStatus.CHECKED_IN)) { // already checked in
					return -2;
				} else { // correct booking id and passenger not Checked-In yet.  
					logger.info("Booking info is " + bookingRecord.toString());
					checkIn.setCheckInTime(new Date());
					logger.info("Saving checkin ");
					long checkInId = checkinRepository.save(checkIn).getId(); //Modified by Ramesh
					logger.info("Successfully saved checkin ");
					
					// Send bookingId to Booking Microservice via RabbitMQ to update the status to CHECKED_ID
					logger.info("Sending booking id " + bookingId);
					sender.send(bookingId);
					return checkInId; //added by Ramesh
				}
			} else { // In case of wrong booking id
				return -1;
			}
		} catch (Exception e) {
			logger.error("BOOKING SERVICE IS NOT AVAILABLE");
			e.printStackTrace();
			System.exit(0);
		}
		return bookingId;
	}

	public CheckInRecord getCheckInRecord(long id) {
		return checkinRepository.findOne(id);
	}

}
