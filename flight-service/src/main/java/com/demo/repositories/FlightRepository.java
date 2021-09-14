package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.models.Flight;
import com.demo.models.FlightId;

public interface FlightRepository extends JpaRepository<Flight, FlightId>{

	@Query(value = "select f.* from Flight f", nativeQuery = true)
	Flight getFlightDetails(Flight flight);
	
	@Query(value = "select max(f.flight_number) from Flight f", nativeQuery = true)
	Integer getMaxFlightNumber(Flight flight);

}
