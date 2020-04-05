package com.eformations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eformations.entities.Elements;
import com.eformations.repository.ElementRepository;



public class ElementController {
	
	
	@Autowired
	private ElementRepository elementRepo;

	@RequestMapping("/add")
	@PostMapping
	public Elements addElement(@RequestBody final Elements element) {
		return elementRepo.save(element);
	}
	
	// list all the users from mongodb store
    @RequestMapping("/all")
	@GetMapping
	public Iterable<Elements> getElements() {
		return elementRepo.findAll();
	}
	
	// update the user data in mongodb store
    @RequestMapping("/update")
	@PostMapping
	public Elements update(@RequestBody final Elements element) {
		final String id = element.getId();
		elementRepo.deleteById(id);
		return elementRepo.save(element);
	}
	
	// delete user by id  from mongodb store 
	@RequestMapping("/delete/{id}")
	@GetMapping
	public void remove(@PathVariable final String id) {
		elementRepo.deleteById(id);
	} 

}
