package com.brownfield.pss.book.component;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//Feign makes writing web service (REST)clients easier
//This annotation tells Spring to create a REST client based on the interface provided.
//The "fares-proxy" is an arbitrary client name, which is used by Ribbon load balancer
//@FeignClient(name = "fares-proxy", url = "http://localhost:8081/fares")
//@FeignClient(name = "fares-proxy")
//@FeignClient(name = "fares-service")
@FeignClient(name = "common-apigateway/api/fare-path") //not working
//@RibbonClient
public interface FareServiceProxy { //Feign doesn't use RestTemplate
	@RequestMapping(value = "/fares/get", method = RequestMethod.GET)
	Fare getFare(@RequestParam(value = "flightNumber") String flightNumber, @RequestParam(value = "flightDate") String flightDate);
}
