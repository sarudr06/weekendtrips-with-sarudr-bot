package com.feuji.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feuji.paymentservice.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

//	Optional<Payment> findByOId(Integer id);

//	List<Payment> findByOrderId(int orderId);

}
