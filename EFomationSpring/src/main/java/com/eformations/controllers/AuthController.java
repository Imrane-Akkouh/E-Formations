package com.eformations.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import com.eformations.entities.Roles;
import com.eformations.entities.Users;
import com.eformations.models.AuthRequest;
import com.eformations.repository.RoleRepository;
import com.eformations.repository.UserRepository;
import com.eformations.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*",allowedHeaders = "*")
public class AuthController {
	@Autowired
    private UserRepository userRepo;
	@Autowired
    private RoleRepository roleRepo;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            Users user = userRepo.findByUsername(authRequest.getUsername());
            user.setLastCheckIn(new Date());
            userRepo.save(user);
        } catch (Exception ex) {
            throw new Exception("Invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
    
    @PostMapping("/register")
    public String register(@RequestBody AuthRequest authRequest) throws Exception {
        Roles role = roleRepo.findByRole(authRequest.getRole());
        Users user = new Users(authRequest.getUsername(), (new BCryptPasswordEncoder()).encode(authRequest.getPassword()),new HashSet<Roles>(Arrays.asList(role)));
        try {
            userRepo.save(user);
        } catch (Exception ex) {
            throw new Exception("Duplicate username");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
    
    
}
