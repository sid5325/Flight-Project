package com.demo.controllers;

public enum ServiceStatus {

	LOGIN_SUCCESS(200, "Login success"),
	LOGIN_FAILURE(500, "Login Failure");

	private final int id;
	private final String message;

	ServiceStatus(int id, String message) {
		this.id = id;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}
}