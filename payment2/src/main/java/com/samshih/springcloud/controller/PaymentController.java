package com.samshih.springcloud.controller;

import javax.annotation.Resource;

import com.samshih.springcloud.entities.CommonResult;
import com.samshih.springcloud.entities.Payment;
import com.samshih.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

	@Resource
	private PaymentService paymentService;

	@Value("${server.port}")
	private String serverPort;

	@PostMapping(value = "/payment/create")
	public CommonResult create(
		@RequestBody
		Payment payment) {
		int result = paymentService.create(payment);
		log.info("create success: {}", result);
		int a = 1;
		if (result > 0) {
			return new CommonResult(200, "create success! serverPort: " + serverPort, result);
		} else {
			return new CommonResult(444, "create fail!", null);
		}
	}

	@GetMapping(value = "/payment/get/{id}")
	public CommonResult getPaymentById(
		@PathVariable("id")
		Long id) {
		Payment payment = paymentService.getPaymentById(id);
		log.info("getPaymentById success: {}", payment);

		if (payment != null) {
			return new CommonResult(200, "getPaymentById success! serverPort: " + serverPort, payment);
		} else {
			return new CommonResult(444, "getPaymentById fail, id: " + id, null);
		}
	}
}
