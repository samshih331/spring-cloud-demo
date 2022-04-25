package com.samshih.springcloud.controller;

import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentConsulController {

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/payment/consul")
	public String paymentConsul() {
		return String.format("springcloud with consul: %s %s", serverPort, UUID.randomUUID());
	}
}
