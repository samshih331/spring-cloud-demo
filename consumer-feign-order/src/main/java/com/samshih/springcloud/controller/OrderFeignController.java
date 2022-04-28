package com.samshih.springcloud.controller;

import javax.annotation.Resource;

import com.samshih.springcloud.entities.CommonResult;
import com.samshih.springcloud.entities.Payment;
import com.samshih.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderFeignController {

	@Resource
	private PaymentFeignService paymentFeignService;

	@GetMapping(value = "/consumer/payment/get/{id}")
	public CommonResult<Payment> getPaymentId(
		@PathVariable("id")
		Long id) {
		return paymentFeignService.getPaymentById(id);
	}

	@GetMapping("/consumer/payment/feign/timeout")
	String paymentFeignTimeout() {
		return paymentFeignService.paymentFeignTimeout();
	}
}
