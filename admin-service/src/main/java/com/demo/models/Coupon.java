package com.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupon {

	@Id
	private String couponCode;
	private String discount;
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
}
