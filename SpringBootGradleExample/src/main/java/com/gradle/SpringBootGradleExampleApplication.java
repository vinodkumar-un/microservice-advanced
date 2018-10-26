package com.gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gradle")
public class SpringBootGradleExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGradleExampleApplication.class, args);
	}
}
