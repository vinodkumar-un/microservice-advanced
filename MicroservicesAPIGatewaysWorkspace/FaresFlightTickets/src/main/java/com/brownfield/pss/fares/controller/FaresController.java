package com.brownfield.pss.fares.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brownfield.pss.fares.component.FaresComponent;
import com.brownfield.pss.fares.entity.Fare;

@RestController
@CrossOrigin
@RequestMapping("/fares")
@RefreshScope
public class FaresController {
	private static final Logger logger = LoggerFactory.getLogger(FaresController.class);
	@Value("${fares.discount}")
	private String faresDiscount;
	
	FaresComponent faresComponent;
	
	@Autowired
	FaresController(FaresComponent faresComponent){
	 this.faresComponent = faresComponent;
	}

	@RequestMapping("/get")
	Fare getFare(@RequestParam(value="flightNumber") String flightNumber, @RequestParam(value="flightDate") String flightDate){
		logger.info("Fares Discount = " + faresDiscount);
		return faresComponent.getFare(flightNumber,flightDate);
	}
}





