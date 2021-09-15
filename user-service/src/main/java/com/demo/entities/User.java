package com.demo.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	private int pnrNumber;
	private String userName;

	private int flightNumber;
	private java.sql.Date date;
	private int seatsBooked;
	private String meal;
	private String ticketStatus;
	private double ticketPicePaid;
	private String emailId;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "passenger_details", joinColumns = @JoinColumn(name = "pnrNumber"))
	private List<Passenger> passenger;

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(int pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public double getTicketPicePaid() {
		return ticketPicePaid;
	}

	public void setTicketPicePaid(double ticketPicePaid) {
		this.ticketPicePaid = ticketPicePaid;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	public User(int pnrNumber, String userName, Date date, int seatsBooked, String meal, String ticketStatus,
			double ticketPicePaid, String emailId, List<Passenger> passenger) {
		super();
		this.pnrNumber = pnrNumber;
		this.userName = userName;
		this.date = date;
		this.seatsBooked = seatsBooked;
		this.meal = meal;
		this.ticketStatus = ticketStatus;
		this.ticketPicePaid = ticketPicePaid;
		this.emailId = emailId;
		this.passenger = passenger;
	}

	public User() {

	}

}