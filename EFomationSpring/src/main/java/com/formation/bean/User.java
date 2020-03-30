package com.formation.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	private Long id;
	private String email;
	private String password;

	
	public User() {
		super();
	}
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
