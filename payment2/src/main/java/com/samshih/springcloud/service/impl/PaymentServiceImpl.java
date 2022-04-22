package com.samshih.springcloud.service.impl;

import javax.annotation.Resource;

import com.samshih.springcloud.dao.PaymentDao;
import com.samshih.springcloud.entities.Payment;
import com.samshih.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Resource
	private PaymentDao paymentDao;

	public int create(Payment payment) {
		return paymentDao.create(payment);
	}

	public Payment getPaymentById(Long id) {
		return paymentDao.getPaymentById(id);
	}
}
