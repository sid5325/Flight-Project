package com.demo.response;

import java.util.List;

import com.demo.models.Passenger;
import com.demo.models.User;

	public class UserResponse {
		private String status;
		private List<User> user;
		private String message;
		private List<Passenger> passenger;

		public List<Passenger> getPassenger() {
			return passenger;
		}

		public void setPassenger(List<Passenger> passenger) {
			this.passenger = passenger;
		}

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

		public UserResponse(String status, List<User> user, String message,List<Passenger> passenger) {
			super();
			this.status = status;
			this.user = user;
			this.message = message;
			this.passenger=passenger;
		}

		public UserResponse() {

		}
	}
