package com.demo.response;

import java.util.List;

import com.demo.models.Flight;

public class FlightResponse {

	private String status;
	private List<Flight> flight;
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Flight> getFlight() {
		return flight;
	}

	public void setFlight(List<Flight> flight) {
		this.flight = flight;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public FlightResponse(String status, List<Flight> flight, String message) {
		super();
		this.status = status;
		this.flight = flight;
		this.message = message;
	}

	public FlightResponse() {

	}

}