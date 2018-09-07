package com.errorhandler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/handleErrors")
	public void doTest() {
		throw new RuntimeException("demo test exception");
	}

}
