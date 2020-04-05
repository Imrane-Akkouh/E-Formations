package com.eformations.controllers;

import com.eformations.entities.Users;
import com.eformations.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins="*",allowedHeaders = "*")
public class UserController {
	@Autowired
    private UserRepository userRepo;
	
	@GetMapping("/user")
    public Users user(@RequestParam String username) {
		System.out.print(username);
		Users user = userRepo.findByUsername(username);
        return user;
    }

}
