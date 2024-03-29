package com.samshih.springcloud.controller;

import java.net.URI;
import java.util.List;
import javax.annotation.Resource;

import com.samshih.springcloud.entities.CommonResult;
import com.samshih.springcloud.entities.Payment;
import com.samshih.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

	//	public static final String PAYMENT_URL = "http://localhost:8001";
	public static final String PAYMENT_URL = "http://PAYMENT-SERVICE";

	@Resource
	private RestTemplate restTemplate;

	@Resource
	private LoadBalancer loadBalancer;

	@Resource
	private DiscoveryClient discoveryClient;

	@GetMapping("/consumer/payment/create")
	public CommonResult<Payment> create(Payment payment) {
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
	}

	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult<Payment> getPayment(
		@PathVariable("id")
		Long id) {
		return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
	}

	@GetMapping("/consumer/payment/getEntity/{id}")
	public CommonResult<Payment> getPayment2(
		@PathVariable("id")
		Long id) {
		ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id,
			CommonResult.class);

		if (entity.getStatusCode().is2xxSuccessful()) {
			return entity.getBody();
		} else {
			return new CommonResult<>(444, "error");
		}
	}

	@GetMapping(value = "/consumer/payment/lb")
	public String getPaymentLB() {
		List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
		if (instances == null || instances.size() <= 0) {
			return null;
		}
		ServiceInstance instance = loadBalancer.instances(instances);
		URI uri = instance.getUri();
		return restTemplate.getForObject(uri + "/payment/lb", String.class);
	}
}
