package com.samshih.springcloud.service;

import com.samshih.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

	int create(Payment payment);

	Payment getPaymentById(
		@Param("id")
		Long id);
}
