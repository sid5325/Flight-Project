package com.demo.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FLIGHT")
public class Flight {

	@EmbeddedId
	private FlightId flightId;
	private Integer flightNumber;
	private String noOfSeats;
	private String businessClassSeats;
	private String nonBusinessClassSeats;
	private String scheduledDays;
	private String meal;
	private double ticketCost;
	private String startFlightTime;
	private String endFlightTime;
	private String status;

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public FlightId getFlightId() {
		return flightId;
	}

	public void setFlightId(FlightId flightId) {
		this.flightId = flightId;
	}

	public String getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(String noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getBusinessClassSeats() {
		return businessClassSeats;
	}

	public void setBusinessClassSeats(String businessClassSeats) {
		this.businessClassSeats = businessClassSeats;
	}

	public String getNonBusinessClassSeats() {
		return nonBusinessClassSeats;
	}

	public void setNonBusinessClassSeats(String nonBusinessClassSeats) {
		this.nonBusinessClassSeats = nonBusinessClassSeats;
	}

	public String getScheduledDays() {
		return scheduledDays;
	}

	public void setScheduledDays(String scheduledDays) {
		this.scheduledDays = scheduledDays;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public double getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}

	public String getStartFlightTime() {
		return startFlightTime;
	}

	public void setStartFlightTime(String startFlightTime) {
		this.startFlightTime = startFlightTime;
	}

	public String getEndFlightTime() {
		return endFlightTime;
	}

	public void setEndFlightTime(String endFlightTime) {
		this.endFlightTime = endFlightTime;
	}

	public Flight(FlightId flightId, Integer flightNumber, String noOfSeats, String businessClassSeats,
			String nonBusinessClassSeats, String scheduledDays, String meal, double ticketCost, String startFlightTime,
			String endFlightTime, String status) {
		super();
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.noOfSeats = noOfSeats;
		this.businessClassSeats = businessClassSeats;
		this.nonBusinessClassSeats = nonBusinessClassSeats;
		this.scheduledDays = scheduledDays;
		this.meal = meal;
		this.ticketCost = ticketCost;
		this.startFlightTime = startFlightTime;
		this.endFlightTime = endFlightTime;
		this.status = status;
	}

	public Flight() {

	}

}
