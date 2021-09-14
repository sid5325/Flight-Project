package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.User;
import com.demo.entities.UserEntityId;
import com.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getUserHistory(UserEntityId user) {
		List<User> userFlightHistory = userRepository.viewUserHistory(user.getEmailId());
		if (userFlightHistory != null) {
			return userFlightHistory;
		} else {
			return null;
		}
	}

	public User getUserHistoryWithPnr(int pnr) {
		User userFlightHistory = userRepository.viewUserHistoryWithPnrNumber(pnr);
		if (userFlightHistory != null) {
			return userFlightHistory;
		} else {
			return null;
		}
	}

}
