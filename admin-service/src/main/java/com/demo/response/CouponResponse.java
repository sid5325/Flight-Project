package com.demo.response;

public class CouponResponse {

	private int discount;
	private String message;

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CouponResponse(int discount, String message) {
		super();
		this.discount = discount;
		this.message = message;
	}
	
	

}
