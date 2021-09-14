package com.demo.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class FlightId implements Serializable {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Flight_Number", length = 15)
	private int flightNumber;

	@Column(name = "Flight_Name", length = 15)
	private String flightName;
	@Column(name = "From_Place", length = 15)
	private String fromPlace;
	@Column(name = "To_Place", length = 15)
	private String toPlace;
	private java.sql.Date flightDate;
	@Column(name = "Instrument_Used", length = 10)
	private String instrumentUsed;

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public java.sql.Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(java.sql.Date flightDate) {
		this.flightDate = flightDate;
	}

	public String getInstrumentUsed() {
		return instrumentUsed;
	}

	public void setInstrumentUsed(String instrumentUsed) {
		this.instrumentUsed = instrumentUsed;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public FlightId(int flightNumber, String flightName, String fromPlace, String toPlace, Date flightDate,
			String instrumentUsed) {
		super();
		this.flightNumber = flightNumber;
		this.flightName = flightName;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.flightDate = flightDate;
		this.instrumentUsed = instrumentUsed;
	}

	public FlightId() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(flightDate, flightNumber, flightName, fromPlace, instrumentUsed, toPlace);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightId other = (FlightId) obj;
		return Objects.equals(flightDate, other.flightDate) && flightNumber == other.flightNumber
				&& Objects.equals(flightName, other.flightName) && Objects.equals(fromPlace, other.fromPlace)
				&& Objects.equals(instrumentUsed, other.instrumentUsed) && Objects.equals(toPlace, other.toPlace);
	}

}