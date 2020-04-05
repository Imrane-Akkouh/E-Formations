package com.eformations.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "formations")
public class Formations implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
    private String id;
    
    private String formation_name;
	
	private String objectives;
	
	private String pre_requisites;
	
    private String establishment;
    
    private Date date;
    
    private int nb_places;
    
    private int nb_enrolled;
    
    private ArrayList<String> elements;
    
    // C O N S T R U C T O R S
	public Formations() {
		super();
	}

	public Formations(String formation_name, String objectives, String pre_requisites, String establishment, Date date,
			int nb_places, int nb_enrolled, ArrayList<String> elements) {
		
		this.formation_name = formation_name;
		this.objectives = objectives;
		this.pre_requisites = pre_requisites;
		this.establishment = establishment;
		this.date = date;
		this.nb_places = nb_places;
		this.nb_enrolled = nb_enrolled;
		this.elements = elements;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFormation_name() {
		return formation_name;
	}

	public void setFormation_name(String formation_name) {
		this.formation_name = formation_name;
	}

	public String getObjectives() {
		return objectives;
	}

	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	public String getPre_requisites() {
		return pre_requisites;
	}

	public void setPre_requisites(String pre_requisites) {
		this.pre_requisites = pre_requisites;
	}

	public String getEstablishment() {
		return establishment;
	}

	public void setEstablishment(String establishment) {
		this.establishment = establishment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNb_places() {
		return nb_places;
	}

	public void setNb_places(int nb_places) {
		this.nb_places = nb_places;
	}

	public int getNb_enrolled() {
		return nb_enrolled;
	}

	public void setNb_enrolled(int nb_enrolled) {
		this.nb_enrolled = nb_enrolled;
	}

	public ArrayList<String> getElements() {
		return elements;
	}

	public void setElements(ArrayList<String> elements) {
		this.elements = elements;
	}	
	
}
