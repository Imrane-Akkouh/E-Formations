package com.eformations.jwt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eformations.jwt.api.entity.User;
import com.eformations.jwt.api.repository.UserRepository;

@RestController
@CrossOrigin(origins="*",allowedHeaders = "*")
public class UserController {
	@Autowired
    private UserRepository userRepo;
	
	@GetMapping("/user")
    public User user(@RequestParam String username) {
		System.out.print(username);
		User user = userRepo.findByUsername(username);
        return user;
    }

}
