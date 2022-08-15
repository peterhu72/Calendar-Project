package com.spring.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CalendarProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalendarProjectApplication.class, args);
	}

}
