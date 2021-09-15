package com.demo.controllers;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.customException.FlightException;
import com.demo.models.Flight;
import com.demo.models.UserRequestBody;
import com.demo.response.FlightResponse;
import com.demo.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService service;

	@GetMapping("/searchAll")
	public FlightResponse getAllFlights() throws FlightException {
		try {
			return new FlightResponse("200", service.getAllFlight(), "All flights fetched successfully");
		} catch (Exception e) {
			throw new FlightException(
					"Error Occured while blocking Flight.Please contact your IT administrator on 8763905325");
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	@ResponseBody
	public FlightResponse updatMovie(@RequestBody Flight flight) throws FlightException {
		try {
			return new FlightResponse("200", null, service.updateFlight(flight));
		} catch (Exception e) {
			throw new FlightException(
					"Error Occured while updating Flight.Please contact your IT administrator on 8763905325");

		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
	public FlightResponse deleteFlight(@RequestBody Flight flight) throws FlightException {
		try {
			return new FlightResponse("200", null, service.deleteFlight(flight));
		} catch (Exception e) {
			throw new FlightException(
					"Error Occured while deleting Flight.Please contact your IT administrator on 8763905325");
		}
	}

	@RequestMapping(value = "/blockFlight", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public FlightResponse blockFlight(@RequestBody Flight flight) throws FlightException {
		try {
			return new FlightResponse("200", null, service.blockFlight(flight));
		} catch (Exception e) {
			throw new FlightException(
					"Error Occured while blocking Flight.Please contact your IT administrator on 8763905325");

		}
	}
	
	@RequestMapping(value = "/unBlockFlight", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public FlightResponse unBlockFlight(@RequestBody Flight flight) throws FlightException {
		try {
			return new FlightResponse("200", null, service.unBlockFlight(flight));
		} catch (Exception e) {
			throw new FlightException(
					"Error Occured while blocking Flight.Please contact your IT administrator on 8763905325");

		}
	}

	@PostMapping("/searchForUser")
	public FlightResponse getAllFlightsForUser(@RequestBody UserRequestBody userRequestBody) throws FlightException {
		try {
			return new FlightResponse("200",
					service.getAllFlightForUser(userRequestBody.getFlightDate(), userRequestBody.getFromPlace(),
							userRequestBody.getToPlace(), userRequestBody.getWay()),
					"All flights fetched successfully");
		} catch (Exception e) {
			throw new FlightException(
					"Error Occured while blocking Flight.Please contact your IT administrator on 8763905325");
		}
	}

}
