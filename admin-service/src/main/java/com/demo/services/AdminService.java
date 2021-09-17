package com.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.AdminDao;
import com.demo.dao.CouponDao;
import com.demo.models.Coupon;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private CouponDao couponDao;

	@Autowired
	private JwtUserDetailsService jwtUserService;

	public String addCoupon(Coupon coupon) {
		Optional<Coupon> coupo = couponDao.findById(coupon.getCouponCode());
		if (!coupo.isPresent()) {
			couponDao.save(coupon);
			return "Coupon added successfully" + " with" + " coupon code " + coupon.getCouponCode();
		} else {
			couponDao.save(coupon);
			return "Coupon updated successfully" + " with" + " coupon code " + coupon.getCouponCode();
		}
	}

	public List<Coupon> viewCoupon() {
		List<Coupon> coupon = couponDao.findAll();
		return coupon;
	}

	public Map<Integer, String> userAddCoupon(String coupon) {
		Map<Integer, String> map = new HashMap<>();
		Optional<Coupon> coupo = couponDao.findById(coupon);
		if (coupo.isPresent()) {
			map.put(coupo.get().getDiscount(), "Coupon code applied successfully");
		} else {
			map.put(0, "Please enter a valid coupon");
		}
		return map;
	}

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
