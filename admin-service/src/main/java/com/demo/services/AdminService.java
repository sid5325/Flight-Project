package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.demo.dao.AdminDao;
import com.demo.models.AdminDto;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private JwtUserDetailsService jwtUserService;

	/*
	 * public UserDetails getVerification(AdminDto admin) { //UserDetails
	 * user=jwtUserService.loadUserByUsername(admin.getUserName()); String
	 * userNameAndPassword = adminDao.getVerification(); String[] split =
	 * userNameAndPassword.split(","); if
	 * (split[0].equalsIgnoreCase(admin.getUserName()) &&
	 * split[1].equals(admin.getPassWord())) { return "Admin Login Successful"; }
	 * else { return "Please check your credentials";
	 * 
	 * return user;
	 * 
	 * }
	 */

}
