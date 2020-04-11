package com.eformations.models;

import java.util.ArrayList;

import com.eformations.entities.Inscriptions;

public class InscriptionModel {

	String formationId;
	
	ArrayList<String> elementsId;
	
	Inscriptions inscription;
	
	public InscriptionModel() {}
	
	public InscriptionModel(String formationId, ArrayList<String> elementsId, Inscriptions inscription) {

		this.formationId = formationId;
		this.elementsId = elementsId;
		this.inscription = inscription;
	}

	public String getFormationId() {
		return formationId;
	}

	public void setFormationId(String formationId) {
		this.formationId = formationId;
	}

	public ArrayList<String> getElementsId() {
		return elementsId;
	}

	public void setElementsId(ArrayList<String> elementsId) {
		this.elementsId = elementsId;
	}

	public Inscriptions getInscription() {
		return inscription;
	}

	public void setInscription(Inscriptions inscription) {
		this.inscription = inscription;
	}	
	
}
