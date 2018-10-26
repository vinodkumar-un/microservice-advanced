package com.errorhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.errorhandler")
public class SpringBootErrorHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootErrorHandlerApplication.class, args);
	}
}
