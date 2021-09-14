package com.demo.customException;

public class FlightException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlightException(String errorMessage) {
		super(errorMessage);

	}

	public FlightException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
