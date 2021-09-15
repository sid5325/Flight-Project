package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.models.Coupon;

public interface CouponDao extends JpaRepository<Coupon, String>{

}
