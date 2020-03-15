package com.apollo.ApolloProject.Mongo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apollo.ApolloProject.Bean.Environment;
import com.apollo.ApolloProject.Mongo.DAO.EnvironmentRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, allowedHeaders = {""})
@RequestMapping("/environment")
public class EnvironmentController {

	@Autowired
    @Lazy
    private EnvironmentRepository envRepo;
	
	// add a environment to mongodb store 
	@RequestMapping("/add")
	@PostMapping
	public Environment add(@RequestBody Environment env) {
		return envRepo.save(env);  
	}
	
	// list all the environments from mongodb store
	@RequestMapping("/all")
	@GetMapping
	public Iterable<Environment> getOrder() { 
		return  envRepo.findAll(); 
	}
	
	// update the environment data in mongodb store
	@RequestMapping("/update")
	@PostMapping
	public Environment update(@RequestBody Environment env) {
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
