package com.gradle.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradleController {
	
	@RequestMapping("/hello")
	public String hello() {
		
		return "Hello World!";
	}

}
