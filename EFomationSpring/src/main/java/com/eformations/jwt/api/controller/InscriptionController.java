package com.eformations.jwt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eformations.jwt.api.entity.Inscriptions;
import com.eformations.jwt.api.repository.InscriptionRepository;

@RestController
@CrossOrigin
@RequestMapping("/inscription")
public class InscriptionController {
	
	@Autowired
	private InscriptionRepository InscriptionRepo;
	
	// add new inscription to mongodb
	@PostMapping("/add")
	public void create(@RequestBody final Inscriptions inscription) {
		InscriptionRepo.save(inscription);
	}
	
	// select all the inscriptions from mongodb 
	@GetMapping("/all")
	public Iterable<Inscriptions> AllInscriptions() {
		
		return InscriptionRepo.findAll();
	}
	
	

}
