package com.samshih.springcloud;

import com.samshih.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderMain {

	public static void main(String[] args) {
		SpringApplication.run(OrderMain.class, args);
	}
}
