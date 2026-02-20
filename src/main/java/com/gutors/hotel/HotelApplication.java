package com.gutors.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelApplication {

	public static void main(String[] args) {
		// triggers component scanning and auto-configuration
		SpringApplication.run(HotelApplication.class, args);
	}

}
