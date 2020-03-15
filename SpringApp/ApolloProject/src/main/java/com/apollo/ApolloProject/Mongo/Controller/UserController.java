package com.apollo.ApolloProject.Mongo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apollo.ApolloProject.Bean.User;
import com.apollo.ApolloProject.Mongo.DAO.UserRepository;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, allowedHeaders = {""})
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserRepository userRepo;
	
	// add a user to mongodb store 
	@RequestMapping("/add")
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userRepo.save(user);  
	}
	
	// list all the users from mongodb store
	@RequestMapping("/all")
	@GetMapping
	public Iterable<User> getUsers() { 
		return  userRepo.findAll(); 
	}
	
	// update the user data in mongodb store
	@RequestMapping("/update")
	@PostMapping
	public User update(@RequestBody User user) {
		Long id = user.getId();
		userRepo.deleteById(id);
		
		return userRepo.save(user);
	}
	
	// delete user by id  from mongodb store 
	@RequestMapping("/{email}")
	@GetMapping
	public void findById(@PathVariable String email) {
		
	   userRepo.findByEmail(email);
	}

	// delete user by id  from mongodb store 
	@RequestMapping("/delete/{id}")
	@GetMapping
	public void remove(@PathVariable Long id) {
		
	   userRepo.deleteById(id);
	}

}
