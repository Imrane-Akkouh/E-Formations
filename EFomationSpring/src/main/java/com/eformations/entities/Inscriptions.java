package com.eformations.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inscriptions")
public class Inscriptions implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
    private String id;
    
    private String user_id;
	
	private String username;
	    
    private String email;
    
    private String address;
    
    private String phone;

	// C O N S T R U C T O R S
	public Inscriptions() {
		super();
	}

	public Inscriptions(String user_id, String username, String email, String address, String phone) {
		super();
		
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	// G E T T E R S   A N D   S E T T E R S
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    
}
