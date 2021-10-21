package com.tripify.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication()
public class TripifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripifyApplication.class, args);
	}

}
