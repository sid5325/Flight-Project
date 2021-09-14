package com.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN")
public class AdminDto {

	@Id
	private String username;
	
	@Column(nullable = false)
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AdminDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public AdminDto() {
		
	}

}
