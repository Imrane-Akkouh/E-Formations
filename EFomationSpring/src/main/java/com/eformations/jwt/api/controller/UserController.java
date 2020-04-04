package com.eformations.jwt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eformations.jwt.api.entity.User;
import com.eformations.jwt.api.repository.UserRepository;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	// add the user to mongodb
	@RequestMapping("/add")
	@PostMapping
	public User create(@RequestBody final User user) {
		return userRepo.save(user);
	}
	
	// list all the users from mongodb store
    @RequestMapping("/all")
	@GetMapping
	public Iterable<User> getUsers() {
		return userRepo.findAll();
	}
	
	// update the user data in mongodb store
    @RequestMapping("/update")
	@PostMapping
	public User update(@RequestBody final User user) {
		final String id = user.getId();
		userRepo.deleteById(id);
		return userRepo.save(user);
	}
	
	// delete user by id  from mongodb store 
	@RequestMapping("/delete/{id}")
	@GetMapping
	public void remove(@PathVariable final String id) {
		userRepo.deleteById(id);
	}
	
}