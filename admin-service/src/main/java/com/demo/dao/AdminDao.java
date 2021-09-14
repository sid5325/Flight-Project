package com.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.AdminDto;

@Repository
public interface AdminDao extends CrudRepository<AdminDto, String> {

	@Query(value = "select user_name,pass_word from Admin ", nativeQuery = true)
	public String getVerification();

}
