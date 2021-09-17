package com.demo.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Embeddable
public class FlightId implements Serializable {

	@Column(name = "Flight_Name", length = 15)
	private String flightName;
	@Column(name = "From_Place", length = 15)
	private String fromPlace;
	@Column(name = "To_Place", length = 15)
	private String toPlace;
	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	private String flightDate;
	@Column(name = "Instrument_Used", length = 10)
	private String instrumentUsed;

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
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

	public FlightId(String flightName, String fromPlace, String toPlace, String flightDate, String instrumentUsed) {
		super();
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
		return Objects.hash(flightDate, flightName, fromPlace, instrumentUsed, toPlace);
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
		return Objects.equals(flightDate, other.flightDate) && Objects.equals(flightName, other.flightName)
				&& Objects.equals(fromPlace, other.fromPlace) && Objects.equals(instrumentUsed, other.instrumentUsed)
				&& Objects.equals(toPlace, other.toPlace);
	}

}