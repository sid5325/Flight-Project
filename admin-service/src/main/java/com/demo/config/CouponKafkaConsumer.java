package com.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.demo.models.Coupon;

@Configuration
@EnableKafka
public class CouponKafkaConsumer {

	@Bean
	public ConsumerFactory<String, Coupon> CouponConsumerFactory() {

		JsonDeserializer<Coupon> deserializer = new JsonDeserializer<>(Coupon.class);
		deserializer.setRemoveTypeHeaders(false);
		deserializer.addTrustedPackages("com.demo.models");
		deserializer.setUseTypeMapperForKey(true);

		Map<String, Object> config = new HashMap<>();

		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_two");
		config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);

		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Coupon> CouponKafkaListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Coupon> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(CouponConsumerFactory());
		return factory;
	}

}
