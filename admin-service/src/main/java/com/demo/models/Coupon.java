package com.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupon {

	@Id
	private String couponCode;
	private int discount;

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

}
