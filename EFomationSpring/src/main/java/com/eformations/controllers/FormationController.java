package com.eformations.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eformations.entities.Formations;
import com.eformations.repository.FormationRepository;

@RequestMapping("/formation")
@RestController
@CrossOrigin
public class FormationController {
	
	@Autowired
	private FormationRepository formationRepo;

	@RequestMapping("/add")
	@PostMapping
	public Formations addFormation(@RequestBody final Formations formation) {
		return formationRepo.save(formation);
	}
	
	// list all the formations from mongodb store
    @RequestMapping("/all")
	@GetMapping
	public Iterable<Formations> getFormations() {
		return formationRepo.findAll();
	}
    // select the formation from mongodb store by id 
    @RequestMapping("/{id}")
	@PostMapping
	public Optional<Formations> getFormation(@PathVariable final String id) {
		return formationRepo.findById(id);
	} 
	
	// update the formations data in mongodb store
    @RequestMapping("/update")
	@PutMapping
	public Formations update(@RequestBody final Formations formation) {
		final String id = formation.getId();
		formationRepo.deleteById(id);
		return formationRepo.save(formation);
	}
	
	// delete formation by id  from mongodb store 
	@RequestMapping("/delete/{id}")
	@DeleteMapping
	public void remove(@PathVariable final String id) {
		formationRepo.deleteById(id);
	} 

}
