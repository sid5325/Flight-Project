package com.demo.utility;

import java.util.List;

import com.demo.entities.User;

public class UserResponse {
	private String status;
	private List<User> user;
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserResponse(String status, List<User> user, String message) {
		super();
		this.status = status;
		this.user = user;
		this.message = message;
	}

	public UserResponse() {

	}
}
