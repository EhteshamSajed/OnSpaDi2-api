package com.personal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OnSpaDi2ApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnSpaDi2ApiApplication.class, args);
	}

}