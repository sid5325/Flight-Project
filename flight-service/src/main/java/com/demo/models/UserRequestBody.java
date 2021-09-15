package com.demo.models;

public class UserRequestBody {

	private String flightDate;
	private String fromPlace;
	private String toPlace;
	private String way;

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public UserRequestBody(String flightDate, String fromPlace, String toPlace, String way) {
		super();
		this.flightDate = flightDate;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.way = way;
	}

	public UserRequestBody() {

	}
}
