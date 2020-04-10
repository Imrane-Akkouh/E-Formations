package com.eformations.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.eformations.entities.Elements;

public class AddFormationModel implements Serializable {
    
    private String formation_name;
    
    private String formateurId;

	private String objectives;
	
	private String pre_requisites;
	
    private String establishment;
    
    private Date date;
    
    private int nb_places;
    
    private boolean validated;
    
    private ArrayList<Elements> elements;
    
    // C O N S T R U C T O R S
	public AddFormationModel() {
		super();
	}

	public AddFormationModel(String formation_name,String formateurId, String objectives, String pre_requisites, String establishment, Date date,
			int nb_places) {
		
		this.formation_name = formation_name;
		this.formateurId = formateurId;
		this.objectives = objectives;
		this.pre_requisites = pre_requisites;
		this.establishment = establishment;
		this.date = date;
		this.nb_places = nb_places;
		this.validated = false;
	}
	
	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public String getFormateurId() {
		return formateurId;
	}

	public void setFormateurId(String formateurId) {
		this.formateurId = formateurId;
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

	public ArrayList<Elements> getElements() {
		return elements;
	}

	public void setElements(ArrayList<Elements> elements) {
		this.elements = elements;
	}	
	
}
