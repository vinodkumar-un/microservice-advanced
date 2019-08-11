package com.brownfield.pss.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableGlobalMethodSecurity
@SpringBootApplication(scanBasePackages = {"com.brownfield.pss.client", "com.brownfield.pss.springsecurity.configuration"})
@EnableDiscoveryClient
public class Application{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}