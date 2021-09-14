package com.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.dao.AdminDao;
import com.demo.models.AdminDto;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// should load from database
		// comparing if user is "demo"
		AdminDto adminDto = adminDao.findById(username).orElse(null);
		/*
		 * String userNameAndPassword = adminDao.getVerification(); String[] split =
		 * userNameAndPassword.split(",");
		 */
		if (adminDto != null) {
			return new User(adminDto.getUsername(), "$2a$10$Rb.h.AJsWPcRbLueoh6m2.iTxWmNDE5/7bXH8QIf.p2MoLt3jqYgm", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}