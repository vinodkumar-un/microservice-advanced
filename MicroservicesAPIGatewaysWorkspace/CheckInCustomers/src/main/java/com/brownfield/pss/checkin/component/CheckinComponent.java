package com.brownfield.pss.checkin.component;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.brownfield.pss.checkin.controller.Sender;
import com.brownfield.pss.checkin.entity.CheckInRecord;
import com.brownfield.pss.checkin.repository.CheckinRepository;

@Configuration
class AppConfig{
	@LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

@Service
public class CheckinComponent {
	private static final Logger logger = LoggerFactory.getLogger(CheckinComponent.class);

	//private static final String bookingURL = "http://BOOKING-SERVICE/booking"; // Added by Ramesh.K

	private static final String bookingURL = "http://common-apigateway/api/booking-path/booking"; // Added by Ramesh.K
	
	@Autowired
	private RestTemplate restTemplate; // Added by Ramesh

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
