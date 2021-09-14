package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.entities.User;
import com.demo.entities.UserEntityId;
import com.demo.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/userHistory")
	public List<User> getUser(UserEntityId user) {
		return service.getUserHistory(user);
	}
	
	@GetMapping("/userHistory/pnr/{pnr}")
	public User getUserBookedDetails(int pnr) {
		return service.getUserHistoryWithPnr(pnr);
	}
	

}
