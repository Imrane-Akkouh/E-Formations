package com.eformations.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inscriptions")
public class Inscriptions implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
    private String id;
	
	@Indexed(name = "lastCheckIn", expireAfter = "7d")
    private Date lastCheckIn;
    
    private String beneficiaireId;
    
    private String formation;

	private String username;
	    
    private String email;
    
    private String address;
    
    private String phone;
    
    private ArrayList<String> elements;

	

	// C O N S T R U C T O R S
	public Inscriptions() {
		super();
	}

	public Inscriptions(String beneficiaireId, String Formation, String username, String email, String address, String phone, ArrayList<String> elements) {
		super();
		this.lastCheckIn = new Date();
		this.beneficiaireId = beneficiaireId;
		this.formation = formation;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.elements = elements;
	}

	// G E T T E R S   A N D   S E T T E R S
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public Date getLastCheckIn() {
		return lastCheckIn;
	}
	
	public void setLastCheckIn(Date lastCheckIn) {
		this.lastCheckIn = lastCheckIn;
	}
	
	public String getBeneficiaireId() {
		return beneficiaireId;
	}

	public void setBeneficiaireId(String beneficiaireId) {
		this.beneficiaireId = beneficiaireId;
	}
	
	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
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
    
	public ArrayList<String> getElements() {
		return elements;
	}

	public void setElements(ArrayList<String> elements) {
		this.elements = elements;
	}
	
}
