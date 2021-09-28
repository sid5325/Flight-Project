package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entities.Passenger;
import com.demo.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	

	
	@Query(value="select u.* from USER u where u.email_id = ?1", nativeQuery = true)
	public List<User> viewUserHistory(String emailId);
	
	/*
	 * @Query(value="select u.* from USER u where u.pnr = ?1", nativeQuery = true)
	 * public User viewUserHistoryWithPnrNumber(int pnr);
	 * 
	 * @Query(
	 * value="select u.* from userdb.passenger_details u where u.pnr_number = ?1",
	 * nativeQuery = true) public List<Passenger> viewPassengerDetails(int pnr);
	 */

	

}

