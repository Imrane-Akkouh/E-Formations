package com.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.bean.Formation;
import com.formation.dao.FormateurRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, allowedHeaders = {""})
@RequestMapping("/environment")
public class FormationController {

	@Autowired
    @Lazy
    private FormateurRepository envRepo;
	
	// add a environment to mongodb store 
	@RequestMapping("/add")
	@PostMapping
	public Formation add(@RequestBody Formation env) {
		return envRepo.save(env);  
	}
	
	// list all the environments from mongodb store
	@RequestMapping("/all")
	@GetMapping
	public Iterable<Formation> getOrder() { 
		return  envRepo.findAll(); 
	}
	
	// update the environment data in mongodb store
	@RequestMapping("/update")
	@PostMapping
	public Formation update(@RequestBody Formation env) {
		Long id = env.getId();
		envRepo.deleteById(id);
		return envRepo.save(env);
	}
	
	// delete environment by id  from mongodb store 
	@RequestMapping("/delete/{id}")
	@GetMapping
	public void remove(@PathVariable Long id) {
		
		envRepo.deleteById(id);
	}
}
