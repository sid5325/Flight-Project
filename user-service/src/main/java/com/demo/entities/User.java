package com.demo.entities;

import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
	@EmbeddedId
	private UserEntityId id;

	private java.sql.Date date;
	private String way;
	private String arrflightTime;
	private String depflightTime;
	private int seatsBooked;
	private String gender;
	private String meal;
	private int seatNumber;
	private String ticketStatus;
	private double ticketPicePaid;

	public UserEntityId getId() {
		return id;
	}

	public void setId(UserEntityId id) {
		this.id = id;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getArrflightTime() {
		return arrflightTime;
	}

	public void setArrflightTime(String arrflightTime) {
		this.arrflightTime = arrflightTime;
	}

	public String getDepflightTime() {
		return depflightTime;
	}

	public void setDepflightTime(String depflightTime) {
		this.depflightTime = depflightTime;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
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

	public User(UserEntityId id, Date date, String way, String arrflightTime, String depflightTime, int seatsBooked,
			String gender, String meal, int seatNumber, String ticketStatus, double ticketPicePaid) {
		super();
		this.id = id;
		this.date = date;
		this.way = way;
		this.arrflightTime = arrflightTime;
		this.depflightTime = depflightTime;
		this.seatsBooked = seatsBooked;
		this.gender = gender;
		this.meal = meal;
		this.seatNumber = seatNumber;
		this.ticketStatus = ticketStatus;
		this.ticketPicePaid = ticketPicePaid;
	}

	public User() {

	}

}