package com.samshih.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Payment2Main {

	public static void main(String[] args) {
		SpringApplication.run(Payment2Main.class, args);
	}
}