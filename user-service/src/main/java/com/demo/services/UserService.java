package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Passenger;
import com.demo.entities.User;
import com.demo.repositories.UserRepository;
import com.demo.utility.PdfGenerator;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PdfGenerator pdfGenerator;
	
	public List<User> getUserHistoryWithMailId(String mail) {
		List<User> opt = userRepository.viewUserHistory(mail);
		if (!(opt.isEmpty() || opt==null)) {
			return opt;
		} else {
			return null;
		}
	}
	
	public List<Passenger> getUserHistoryWithPnr(int pnr) {
		Optional<User> opts = userRepository.findById(pnr);
		List<Passenger> opt =opts.get().getPassenger();
		if (!(opt.isEmpty() || opt==null)) {
			return opt;
		} else {
			return null;
		}
	}
	
	public String bookUser(User user) {
		int pnrNumber = pnrNumber();
		user.setPnrNumber(pnrNumber);
		User userFlightHistory = userRepository.save(user);
		pdfGenerator.pdfGenerator(user);
		if (userFlightHistory != null) {
			return "User details booked successfully with pnr " + pnrNumber;
		} else {
			return "User details unable to book";
		}
	}
	
	public int pnrNumber() {
		int max = 10000;
		int min = 1000;
		int range = max - min + 1;
		int rand = (int) (Math.random() * range) + min;
		return rand;
	}

	
	public String deleteByPnr(int pnr) {
		Optional<User> opt = userRepository.findById(pnr);
		if (opt.isPresent()) {
			userRepository.deleteById(pnr);
			return "User with " + pnr + " got successfully deleted";
		} else {
			return "The pnr number you are trying to search is not found";
		}
	}
}
