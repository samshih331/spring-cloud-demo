package com.samshih.springcloud.controller;

import javax.annotation.Resource;

import com.samshih.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderHystrixController {

	@Resource
	private PaymentHystrixService paymentHystrixService;

	@GetMapping("/consumer/payment/hystrix/ok/{id}")
	String paymentInfo_OK(
		@PathVariable("id")
		Integer id) {
		return paymentHystrixService.paymentInfo_OK(id);
	}

	@GetMapping("/consumer/payment/hystrix/timeout/{id}")
	String paymentInfo_TimeOut(
		@PathVariable("id")
		Integer id) {
		return paymentHystrixService.paymentInfo_TimeOut(id);
	}
}