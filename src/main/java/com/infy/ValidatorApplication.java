package com.infy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ValidatorApplication {

	public static void main(String[] args) {
		System.out.println("start");
		SpringApplication.run(ValidatorApplication.class, args);
		System.out.println("end");
	}

}
