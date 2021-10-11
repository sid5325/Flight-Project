package com.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.demo.config.CouponKafkaProducer;
import com.demo.dao.AdminDao;
import com.demo.dao.CouponDao;
import com.demo.exception.DataNotFoundException;
import com.demo.models.Coupon;
import com.demo.response.CouponResponse;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private CouponDao couponDao;

	@Autowired
	private JwtUserDetailsService jwtUserService;
	
	@Autowired
	private KafkaTemplate<String,Coupon> couponKafka;

	public String addCoupon(Coupon coupon)  {
		/*try {*/
		Optional<Coupon> coupo = couponDao.findById(coupon.getCouponCode());
		if (!coupo.isPresent()) {
			//couponDao.save(coupon);
			//CouponKafkaProducer couponKafkaProducer=new CouponKafkaProducer();
			couponKafka.send("coupontopic",coupon);
			return "Coupon added successfully" + " with" + " coupon code " + coupon.getCouponCode();
		} else {
			couponDao.save(coupon);
			return "Coupon updated successfully" + " with" + " coupon code " + coupon.getCouponCode();
		}
		/*
		 * }catch(Exception e) { throw new
		 * DataNotFoundException("Exception occured during add coupon by admin"); }
		 */
	}

	public List<Coupon> viewCoupon() {
		List<Coupon> coupon = couponDao.findAll();
		return coupon;
	}

	public CouponResponse userAddCoupon(String coupon) {
		/* try { */
		Optional<Coupon> coupo = couponDao.findById(coupon);
		if (coupo.isPresent()) {
			return new CouponResponse(coupo.get().getDiscount(),"Coupon code applied successfully");
		} else {
			return new CouponResponse(0,"Please enter a valid coupon");
		}
		/*}catch(Exception e) {
			throw new DataNotFoundException("Exception occured when user is trying to add coupon");
		}*/
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
