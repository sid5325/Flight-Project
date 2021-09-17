package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.customException.FlightException;
import com.demo.models.Flight;
import com.demo.repositories.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;

	public List<Flight> getAllFlight() {
		return flightRepository.findAll();

	}

	@SuppressWarnings("removal")
	public String updateFlight(Flight flight) throws FlightException {

		try {
			if (flightRepository.findById(flight.getFlightId()).isPresent()) {
				/*
				 * Integer flightNumber = flightRepository.getMaxFlightNumber(flight); FlightId
				 * id = new FlightId(); id.setFlightDate(flight.getFlightId().getFlightDate());
				 * id.setFlightNumber(flightNumber);
				 * id.setFlightName(flight.getFlightId().getFlightName());
				 * id.setFromPlace(flight.getFlightId().getFromPlace());
				 * id.setInstrumentUsed(flight.getFlightId().getInstrumentUsed());
				 * id.setToPlace(flight.getFlightId().getToPlace()); flight.setFlightId(id);
				 */
				flightRepository.save(flight);
				return "Flight details updated by admin";
			} else {
				Integer flightNumber = flightRepository.getMaxFlightNumber(flight);
				/*
				 * FlightId id = new FlightId();
				 * id.setFlightDate(flight.getFlightId().getFlightDate());
				 */
				if(flightNumber==null) {
					flight.setFlightNumber(new Integer(1));
				}else {
					flight.setFlightNumber(flightNumber + 1);
				}
				/*
				 * id.setFlightName(flight.getFlightId().getFlightName());
				 * id.setFromPlace(flight.getFlightId().getFromPlace());
				 * id.setInstrumentUsed(flight.getFlightId().getInstrumentUsed());
				 * id.setToPlace(flight.getFlightId().getToPlace()); flight.setFlightId(id);
				 */
				flightRepository.save(flight);
				return "Flight details stored by admin";
			}

		} catch (Exception e) {
			throw new FlightException("Error Occured while updating Flight details", e);
		}

	}

	public Flight getFlight(Flight flight) throws FlightException {
		Flight flight1 = new Flight();
		try {
			Optional<Flight> optional = flightRepository.findById(flight.getFlightId());
			if (optional.isPresent()) {
				flight1 = optional.get();
				return flight1;
			}

		} catch (Exception e) {
			throw new FlightException("Flight not found in db", e);
		}
		return flight1;
	}

	@ExceptionHandler(value = FlightException.class)
	public String deleteFlight(Flight flight) throws FlightException {
		Flight flightFromDb = getFlight(flight);
		if (flightFromDb == null) {
			return "The Flight you are trying to delete is not present from Database";
		}

		else {
			flightRepository.delete(flightFromDb);
			return "Flight successfully deleted from Database";
		}
	}

	@ExceptionHandler(value = FlightException.class)
	public String blockFlight(Flight flight) throws FlightException {
		Flight flightFromDb = getFlight(flight);
		if (flightFromDb == null) {
			return "The Flight You are trying to block is not present in Database";
		}

		else {
			flightFromDb.setStatus("Disable");
			flightRepository.save(flightFromDb);
			return "Flight disabled and the details won't be visible to User";
		}
	}
	
	@ExceptionHandler(value = FlightException.class)
	public String unBlockFlight(Flight flight) throws FlightException {
		Flight flightFromDb = getFlight(flight);
		if (flightFromDb == null) {
			return "The Flight You are trying to enable is not present in Database";
		}

		else {
			flightFromDb.setStatus("Enable");
			flightRepository.save(flightFromDb);
			return "Flight enabled and the details be visible to User";
		}
	}
	
	public List<Flight> getAllFlightForUser(String flightDate,String fromPlace,String ToPlace) {
		return flightRepository.findFlightForUser(flightDate,fromPlace,ToPlace);

	}

}
