package com.user.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * 
 * @author Rajeev
 * RegistrationApplication is SpringBoot application
 */
public class RegistrationApplication {
	
	static final Logger log = 
	        LoggerFactory.getLogger(RegistrationApplication.class);

	public static void main(String[] args) {
		log.info("Inside RegistrationApplication start");
		SpringApplication.run(RegistrationApplication.class, args);
		log.info("RegistrationApplication end");
	}

}
