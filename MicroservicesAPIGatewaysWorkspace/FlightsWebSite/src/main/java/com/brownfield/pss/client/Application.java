package com.brownfield.pss.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity
@SpringBootApplication(scanBasePackages = "com.brownfield.pss.client")
@EnableDiscoveryClient
public class Application{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}