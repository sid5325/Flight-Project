package com.demo.controllers;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.customException.FlightException;
import com.demo.models.Flight;
import com.demo.response.FlightResponse;
import com.demo.service.FlightService;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/v3/api/flight/")
public class FlightController {

	@Autowired
	private FlightService service;

	@GetMapping("/searchAll")
	public FlightResponse getAllFlights() throws FlightException {
		try {
			return new FlightResponse("200", service.getAllFlight(), "All flights fetched successfully", null);
		} catch (Exception e) {
			throw new FlightException(
					"Error Occured while blocking Flight.Please contact your IT administrator on 8763905325");
		}
	}
	
	@GetMapping("/searchById/{flightNumber}")
	public FlightResponse getAllFlights(@PathVariable Integer flightNumber) throws FlightException {
		try {
			return new FlightResponse("200", service.getAllFlight(), "flight number:"+flightNumber +" fetched successfully", null);
		} catch (Exception e) {
			throw new FlightException(
					"Error Occured while blocking Flight.Please contact your IT administrator on 8763905325");
		}
	}

	// @RequestMapping(value = "/add", method = RequestMethod.POST, produces =
	// MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	// @ResponseBody
	@PostMapping("/add")
	public FlightResponse updatMovie(@RequestBody Flight flight) throws FlightException {
		try {
			return new FlightResponse("200", null, service.updateFlight(flight), null);
		} catch (Exception e) {
			throw new FlightException(
					"Error Occured while updating Flight.Please contact your IT administrator on 8763905325");

		}
	}

	//@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@DeleteMapping("/delete/{id}")
	public FlightResponse deleteFlight(@PathVariable int id) throws FlightException {
		try {
			return new FlightResponse("200", null, service.deleteFlight(id), null);
		} catch (Exception e) {
			throw new FlightException(
					"Error Occured while deleting Flight.Please contact your IT administrator on 8763905325");
		}
	}

	//@RequestMapping(value = "/blockFlight", method = RequestMethod.POST, produces =org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes =org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/blockFlight/{id}")
	public FlightResponse blockFlight(@PathVariable int id) throws FlightException {
		try {
			return new FlightResponse("200", null, service.blockFlight(id), null);
		} catch (Exception e) {
			throw new FlightException(
					"Error Occured while blocking Flight.Please contact your IT administrator on 8763905325");

		}
	}

	//@RequestMapping(value = "/unBlockFlight", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@PostMapping("/unBlockFlight/{id}")
	public FlightResponse unBlockFlight(@PathVariable int id) throws FlightException {
		try {
			return new FlightResponse("200", null, service.unBlockFlight(id), null);
		} catch (Exception e) {
			throw new FlightException(
					"Error Occured while blocking Flight.Please contact your IT administrator on 8763905325");

		}
	}

	@GetMapping("/getFlightForUser/{flightDate}/{fromPlace}/{toPlace}")
	public FlightResponse getAllFlightForUser(@PathVariable String flightDate, @PathVariable String fromPlace,
			@PathVariable String toPlace) throws FlightException {
		try {
			List<Flight> flight=service.getAllFlightForUser(flightDate, fromPlace, toPlace);
			if(flight!=null && !flight.isEmpty()) {
			return new FlightResponse("200", service.getAllFlightForUser(flightDate, fromPlace, toPlace),
					"Flights from " + fromPlace + " to " + toPlace + " fetched successfully", null);
			}else {
				return new FlightResponse("200", null,
						"There are no flights to show", null);
			}
		} catch (Exception e) {
			throw new FlightException(
					"Error Occured while blocking Flight.Please contact your IT administrator on 8763905325");

		}
	}

}
