package com.samshih.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Payment3Main {

	public static void main(String[] args) {
		SpringApplication.run(Payment3Main.class, args);
	}
}