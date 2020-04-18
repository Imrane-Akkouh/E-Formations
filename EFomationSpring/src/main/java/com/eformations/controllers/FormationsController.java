package com.eformations.controllers;

import com.eformations.entities.Elements;
import com.eformations.entities.Formations;
import com.eformations.entities.Inscriptions;
import com.eformations.entities.Users;
import com.eformations.models.AddFormationModel;
import com.eformations.models.InscriptionModel;
import com.eformations.repository.ElementsRepository;
import com.eformations.repository.FormationRepository;
import com.eformations.repository.InscriptionRepository;
import com.eformations.repository.UserRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

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
    
    @Autowired
    private InscriptionRepository inscriptionRepo;
   
    
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
    
    @RequestMapping(value = "/getFormation", method = RequestMethod.GET)
    public Optional<Formations> getFormation(@RequestParam (name="formationId") String formationId) {
    	Optional<Formations> formation = formationRepo.findById(formationId);
    	return formation;
    }
    
    @RequestMapping(value = "/addFormation", method = RequestMethod.POST)
    public Formations addFormation(@RequestBody AddFormationModel addFormationModel ) {
    	Optional<Users> user = userRepo.findById(addFormationModel.getFormateurId());
    	
    	//Destructure received data
    	Formations formationToSave = new Formations(
    			addFormationModel.getFormation_name(),
    			addFormationModel.getFormateurId(),
    			addFormationModel.getObjectives(),
    			addFormationModel.getPre_requisites(),
    			addFormationModel.getEstablishment(),
    			addFormationModel.getDate(),
    			addFormationModel.getNb_places(),
    			0,
    			addFormationModel.getTotalPrice(),
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
    	
    	Formations formation = formationRepo.save(formationToSave);
    	ArrayList<String> formations = user.get().getFormations();
    	formations.add(formation.getId());
    	user.get().setFormations(formations);
    	userRepo.save(user.get());
		return formation;
    }
    
    @RequestMapping(value = "/validateFormation", method = RequestMethod.GET)
    public Optional<Formations> validateFormation(@RequestParam (name="formationId") String formationId) {
    	Optional<Formations> formation = formationRepo.findById(formationId);
    	if(formation.isPresent()) {
    		formation.get().setValidated(true);
    		formationRepo.save(formation.get());
    	}
    	return formation;
    }
    
    @RequestMapping(value = "/getInscription", method = RequestMethod.GET)
    public Inscriptions getInscription(@RequestParam (name="formation") String formationId, @RequestParam (name="username") String username) {
    	Inscriptions inscript = inscriptionRepo.findByFormationAndUsername(formationId, username);
    	if(inscript!=null) {
    		return inscript;
    	}else {
    		return null;
    	}
    }
    
    @RequestMapping(value = "/reactivateInscription", method = RequestMethod.GET)
    public String reactivateInscription(@RequestParam (name="formation") String formationId, @RequestParam (name="username") String username) {
    	Inscriptions inscript = inscriptionRepo.findByFormationAndUsername(formationId, username);
    	try {
    		inscript.setLastCheckIn(new Date());
    		inscriptionRepo.save(inscript);
    		return "successfully reactivated";
    	}catch(Exception e) {
    		return e.toString();
    	}
    }

    @RequestMapping(value = "/formationInscription", method = RequestMethod.POST)
    public String formationInscription(@RequestBody InscriptionModel formationInscription ) throws Exception {
    
    	try {
	    	//save inscription
    		Inscriptions inscript = formationInscription.getInscription();
    		inscript.setLastCheckIn(new Date());
	    	inscriptionRepo.save(inscript);
	    	
	    	//Increment nb_beneficiaries of chosen Elements document
	    	if (formationInscription.getElementsId().size() != 0) {
	        	
	    		ArrayList<Elements> chosenElements = (ArrayList<Elements>) elementsRepo.findByIdIn(formationInscription.getElementsId());

	        	for (Elements element : chosenElements) {
	        		element.setNb_beneficiaries(element.getNb_beneficiaries()+1);
	        	}
	        	
	        	elementsRepo.saveAll(chosenElements);

	    	}
	
	       	//Increment nb_enrolled of chosen Formation document
	    	Formations chosenFormation = formationRepo.findById(formationInscription.getFormationId()).orElse(null);
	    	
	    	if (chosenFormation != null) {
	    		
	    		chosenFormation.setNb_enrolled(chosenFormation.getNb_enrolled()+1);
	  
	    		formationRepo.save(chosenFormation);
	    	}
	    	
	    	// //Add this formation's id to the list of formation ids of the currently logged in beneficiaire
	    	// Users currentUser = userRepo.findById(formationInscription.getInscription().getBeneficiaireId()).orElse(null);
	    	
	    	// if (currentUser != null && !currentUser.getFormations().contains(formationInscription.getFormationId())) {
	    		
	    	// 	currentUser.getFormations().add(formationInscription.getFormationId());
	    		
	    	// 	userRepo.save(currentUser);
	    	// }
	    	
	    	return "successful";
    	
    	}catch (Exception err) {
    		throw new Exception ("failed :" + err);
    	}
    }
}
