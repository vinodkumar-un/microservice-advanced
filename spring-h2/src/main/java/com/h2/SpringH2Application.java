package com.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.h2")
public class SpringH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringH2Application.class, args);
	}

}
