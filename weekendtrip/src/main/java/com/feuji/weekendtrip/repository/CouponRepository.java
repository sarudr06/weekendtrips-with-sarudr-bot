package com.feuji.weekendtrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feuji.weekendtrip.model.Coupon;

public interface CouponRepository  extends JpaRepository<Coupon, Integer>{

}