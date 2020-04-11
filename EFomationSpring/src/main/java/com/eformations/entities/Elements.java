package com.eformations.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "elements")
public class Elements implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
    private String id;
	
	private String formateurId;

	private String element_name;
	
	private int duration;
	    
    private Date date;
    
    private float cost;
    
    private int nb_beneficiaries;

	// C O N S T R U C T O R S
	public Elements() {
		super();
	}
	
	public Elements(String formateurId, String element_name, int duration, Date date, float cost, int nb_beneficiaries) {
		super();
		
		this.element_name = element_name;
		this.formateurId = formateurId;
		this.duration = duration;
		this.date = date;
		this.cost = cost;
		this.nb_beneficiaries = nb_beneficiaries;
	}
	
	public String getFormateurId() {
		return formateurId;
	}

	public void setFormateurId(String formateurId) {
		this.formateurId = formateurId;
	}

	// G E T T E R S   A N D   S E T T E R S
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getElement_name() {
		return element_name;
	}

	public void setElement_name(String element_name) {
		this.element_name = element_name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getNb_beneficiaries() {
		return nb_beneficiaries;
	}

	public void setNb_beneficiaries(int nb_beneficiaries) {
		this.nb_beneficiaries = nb_beneficiaries;
	}
    
}
