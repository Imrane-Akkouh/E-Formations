package com.formation.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")

public class Formateur implements Serializable {

	private static final long serialVersionUID = 1L;
	
	enum oderType {
	    PLATFILE,
	    MQSERIES,
	  }
	@Id
	private Long id;
	private String name;
	private String type;
	
	
	public Formateur() {
	}
	
	public Formateur(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
