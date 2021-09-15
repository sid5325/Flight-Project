package com.demo.customException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerExceptionAdvice {
	@ExceptionHandler(FlightException.class)
	public ResponseEntity<String> handleNotFoundException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
	}
}
