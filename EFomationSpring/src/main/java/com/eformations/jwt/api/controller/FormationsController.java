package com.eformations.jwt.api.controller;

import com.eformations.jwt.api.entity.Formations;
import com.eformations.jwt.api.repository.FormationRepository;
import com.eformations.jwt.api.repository.UserRepository;


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
   
    
    @RequestMapping(value = "/myFormations", method = RequestMethod.GET)
    public ArrayList<Formations> getFormation(@RequestParam (name="username") String username ) {
    	
    	System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWSSSSSSSSSSSSSEEEEEEEEEERRRRRRRRRR "+ username);
    	
    	ArrayList<String> allMyFormationsId = userRepo.findByUsername(username).getFormations();

    	if (allMyFormationsId != null) {
    	
    		return formationRepo.findAllById(allMyFormationsId);
            
    	}
    	
    	return new ArrayList<Formations>();
    }   
    
}
