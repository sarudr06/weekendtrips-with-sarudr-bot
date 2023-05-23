package com.feuji.paymentservice.service;

import com.feuji.paymentservice.model.Payment;

public interface PaymentService {
	
	public String paymentProcessing();
	
	public Payment doPayment(Payment payment);

}
