package com.apollo.ApolloProject.Bean;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "environments")
public class Environment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String name;
	private ArrayList<String> clients;
	
	
	public Environment() {
		super();
	}
	public Environment(String name, ArrayList<String> clients) {
		super();
		this.name = name;
		this.clients = clients;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getClients() {
		return clients;
	}
	public void setClients(ArrayList<String> clients) {
		this.clients = clients;
	} 

}
