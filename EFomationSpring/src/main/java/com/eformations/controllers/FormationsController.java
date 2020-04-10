package com.eformations.controllers;

import com.eformations.entities.Elements;
import com.eformations.entities.Formations;
import com.eformations.models.AddFormationModel;
import com.eformations.repository.ElementsRepository;
import com.eformations.repository.FormationRepository;
import com.eformations.repository.UserRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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
    		ArrayList<Formations> alf =  formationRepo.findByIdIn(allMyFormationsId);
    		return alf;
    	}
    	return new ArrayList<Formations>();
    }
    
    
    @RequestMapping(value = "/formationElements", method = RequestMethod.GET)
    public ArrayList<Elements> getFormationElements(@RequestParam (name="formationId") String formationId ) {
    	
    	ArrayList<String> formationElementsIds = formationRepo.findById(formationId).get().getElements();
    	
    	if (formationElementsIds != null) {
    		return elementsRepo.findByIdIn(formationElementsIds); 
    	}
    	
    	return new ArrayList<Elements>();
    }
    
    @RequestMapping(value = "/allFormations", method = RequestMethod.GET)
    public ArrayList<Formations> getAllFormations() {
    	
    	Date currentDate = new Date();

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        // manipulate date
        c.add(Calendar.MONTH, 1);

        // convert calendar to date
        Date currentDatePlusOne = c.getTime();
    	
    	ArrayList<Formations> alf =  formationRepo.findByDateBetween(currentDate, currentDatePlusOne);
    	
    	return alf;
    }
    
    @RequestMapping(value = "/addFormation", method = RequestMethod.POST)
    public Formations addFormation(@RequestBody AddFormationModel addFormationModel ) {
    	
    	//Destructure received data
    	Formations formationToSave = new Formations(
    			addFormationModel.getFormation_name(),
    			addFormationModel.getFormateurId(),
    			addFormationModel.getObjectives(),
    			addFormationModel.getPre_requisites(),
    			addFormationModel.getEstablishment(),
    			addFormationModel.getDate(),
    			addFormationModel.getNb_places(),
    			new ArrayList<String>()
    		);
    	
    	// If there are elements to be added
    	if (addFormationModel.getElements().size() != 0) {
        	ArrayList<Elements> savedElements =	(ArrayList<Elements>) elementsRepo.saveAll(addFormationModel.getElements());
        	
        	ArrayList<String> savedElementsIds = new ArrayList<String>();
        	
        	for(Elements element : savedElements) {
        		savedElementsIds.add(element.getId());
        	}
        	
        	formationToSave.setElements(savedElementsIds);	
    	}    	
    	
    	return formationRepo.save(formationToSave);
    }
    
    

}
