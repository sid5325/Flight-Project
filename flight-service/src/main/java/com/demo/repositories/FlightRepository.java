package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.models.Flight;
import com.demo.models.FlightId;
@Repository
public interface FlightRepository extends JpaRepository<Flight, FlightId> {

	@Query(value = "select f.* from Flight f", nativeQuery = true)
	Flight getFlightDetails(Flight flight);

	@Query(value = "select max(f.flight_number) from Flight f", nativeQuery = true)
	Integer getMaxFlightNumber(Flight flight);

	@Query(value = "select f.* from Flight f where flight f.flight_date=?1 and f.from_place=?2 and f.to_place=?3 and f.way=?4", nativeQuery = true)
	List<Flight> findAllForUser(String flightDate, String fromPlace, String ToPlace, String way);

}
