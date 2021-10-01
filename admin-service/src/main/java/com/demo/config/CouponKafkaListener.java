package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.demo.dao.CouponDao;
import com.demo.models.Coupon;

@Service
public class CouponKafkaListener {
	private static final String TOPIC = "coupontopic";
	@Autowired
	private CouponDao repo;

	@KafkaListener(topics = TOPIC, groupId = "group_two", containerFactory = "CouponKafkaListenerFactory")

	public void consumeJson(@Payload Coupon coupon, @Headers MessageHeaders headers) {
		System.out.println("coupoun consumes");
		repo.save(coupon);
		System.out.println("Consumed JSON Message: " + coupon);
	}

}
