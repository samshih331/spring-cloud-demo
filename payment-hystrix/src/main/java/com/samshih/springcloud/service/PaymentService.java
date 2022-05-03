package com.samshih.springcloud.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	public String paymentInfo_OK(Integer id) {
		return "thread 	pool: " + Thread.currentThread().getName() + " paymentInfo_OK, id: " + id + " ^_^ ";
	}

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
}
