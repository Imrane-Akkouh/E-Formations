package com.eformations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eformations.entities.Users;
import com.eformations.repository.UserRepository;


@RestController
@CrossOrigin(origins="*",allowedHeaders = "*")
public class UserController {
	@Autowired
    private UserRepository userRepo;
	
	@GetMapping("/user")
    public Users user(@RequestParam String username) {
		Users user = userRepo.findByUsername(username);
		System.out.print(user.getRated_fromations());
        return user;
    }

}
