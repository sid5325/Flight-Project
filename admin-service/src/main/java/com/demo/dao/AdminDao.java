package com.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.AdminDto;

@Repository
public interface AdminDao extends CrudRepository<AdminDto, String> {

	@Query(value = "select username,password from admin ", nativeQuery = true)
	public String getVerification();

}
