package com.samshih.springcloud.service;

import java.util.concurrent.TimeUnit;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	public String paymentInfo_OK(Integer id) {
		return "thread 	pool: " + Thread.currentThread().getName() + " paymentInfo_OK, id: " + id + " ^_^ ";
	}

	@HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
	})
	public String paymentInfo_TimeOut(Integer id) {
		int timeNumber = 3;
		try {
			TimeUnit.SECONDS.sleep(timeNumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "thread 	pool: " + Thread.currentThread().getName() + " paymentInfo_TimeOut, id: " + id
			+ " ^_^ takes " + timeNumber + " seconds ";
	}

	public String paymentInfo_TimeoutHandler(Integer id) {
		return "thread 	pool: " + Thread.currentThread().getName() + " paymentInfo_TimeoutHandler, id: " + id
			+ " T_T ";
	}
}
