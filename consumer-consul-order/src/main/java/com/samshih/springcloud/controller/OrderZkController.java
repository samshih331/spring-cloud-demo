package com.samshih.springcloud.controller;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderZkController {

	public static final String INVOKE_URL = "http://consul-payment-service";

	@Resource
	private RestTemplate restTemplate;

	@GetMapping("/consumer/payment/consul")
	public String paymentInfo() {
		return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
	}
}
