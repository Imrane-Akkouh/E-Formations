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

import com.formation.bean.Formateur;
import com.formation.dao.FormationRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, allowedHeaders = {""})
@RequestMapping("/order")
public class FormateurController {

	
	@Autowired
    @Lazy
    private FormationRepository orderRepo;
	
	// add a order to mongodb store 
	@RequestMapping("/add")
	@PostMapping
	public Formateur addOrder(@RequestBody Formateur order) {
		return orderRepo.save(order);  
	}
	
	// list all the orders from mongodb store
	@RequestMapping("/all")
	@GetMapping
	public Iterable<Formateur> getOrder() { 
		return  orderRepo.findAll(); 
	}
	
	// update the order data in mongodb store
	@RequestMapping("/update")
	@PostMapping
	public Formateur update(@RequestBody Formateur order) {
		Long id = order.getId();
		orderRepo.deleteById(id);
		return orderRepo.save(order);
	}
	
	// delete order by id  from mongodb store 
	@RequestMapping("/delete/{id}")
	@GetMapping
	public void remove(@PathVariable Long id) {
		
		orderRepo.deleteById(id);
	}

}
