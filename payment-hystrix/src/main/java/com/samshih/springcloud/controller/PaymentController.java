package com.samshih.springcloud.controller;

import javax.annotation.Resource;

import com.samshih.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

	@Resource
	private PaymentService paymenyService;

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(
		@PathVariable("id")
		Integer id) {
		String result = paymenyService.paymentInfo_OK(id);
		log.info("result: {}", result);
		return result;
	}

	@GetMapping("/payment/hystrix/timeout/{id}")
	public String paymentInfo_TimeOut(
		@PathVariable("id")
		Integer id) {
		String result = paymenyService.paymentInfo_TimeOut(id);
		log.info("result: {}", result);
		return result;
	}
}
