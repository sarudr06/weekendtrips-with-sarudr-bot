package com.feuji.paymentservice.serviceImpl;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.paymentservice.model.Payment;
import com.feuji.paymentservice.repository.PaymentRepository;
import com.feuji.paymentservice.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public String paymentProcessing() {
		//we will integrate api here paytm or phonepay.
		return new Random().nextBoolean()?"success":"failure";
	}

	@Override
	public Payment doPayment(Payment payment) {
		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setPaymentStatus(paymentProcessing());
		return paymentRepository
				.save(payment);
	}
	


}
