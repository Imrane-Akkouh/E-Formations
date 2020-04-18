package com.eformations.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eformations.entities.Elements;
import com.eformations.entities.Formations;
import com.eformations.repository.ElementsRepository;
import com.eformations.repository.FormationRepository;

 

public class ElementController {
	
	
	@Autowired
	private ElementsRepository elementsRepo;
	
	@Autowired
	private FormationRepository formationRepo;

	@RequestMapping("/add")
	@PostMapping
	public Elements addElement(@RequestBody final Elements element) {
		return elementsRepo.save(element);
	}
	
	// list all the elements of a formation from mongo
	
    @RequestMapping(value = "/formationElements", method = RequestMethod.GET)
    public Optional<Formations> getFormationElements(@RequestParam (name="formationId") String formationId ) {
    	 
    	return formationRepo.findById(formationId);
    }   

}
