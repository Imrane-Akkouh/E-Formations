package com.eformations.controllers;

import com.eformations.entities.Elements;
import com.eformations.entities.Formations;
import com.eformations.repository.ElementsRepository;
import com.eformations.repository.FormationRepository;
import com.eformations.repository.UserRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FormationsController {
	
	@Autowired
    private UserRepository userRepo;
    
    @Autowired
    private FormationRepository formationRepo;
    
    @Autowired
    private ElementsRepository elementsRepo;
   
    
    @RequestMapping(value = "/myFormations", method = RequestMethod.GET)
    public ArrayList<Formations> getFormations(@RequestParam (name="username") String username ) {
    	
    	ArrayList<String> allMyFormationsId = userRepo.findByUsername(username).getFormations();
    	
    	if (allMyFormationsId != null) {
    		return formationRepo.findAllById(allMyFormationsId); 
    	}
    	return new ArrayList<Formations>();
    }
    
    @RequestMapping(value = "/formationElements", method = RequestMethod.GET)
    public ArrayList<Elements> getFormationElements(@RequestParam (name="formationId") String formationId ) {
    	
    	ArrayList<String> formationElementsIds = formationRepo.findById(formationId).get().getElements();
    	
    	if (formationElementsIds != null) {
    		return elementsRepo.findAllById(formationElementsIds); 
    	}
    	
    	return new ArrayList<Elements>();
    }   
    

}
