package com.eformations.jwt.api.controller;

import com.eformations.jwt.api.entity.AuthRequest;
import com.eformations.jwt.api.entity.Role;
import com.eformations.jwt.api.entity.User;
import com.eformations.jwt.api.repository.RoleRepository;
import com.eformations.jwt.api.repository.UserRepository;
import com.eformations.jwt.api.util.JwtUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
        } catch (Exception ex) {
            throw new Exception("Invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
    
    @PostMapping("/register")
    public String register(@RequestBody AuthRequest authRequest) throws Exception {
        Role role = roleRepo.findByRole(authRequest.getRole());
        User user = new User(authRequest.getUsername(), (new BCryptPasswordEncoder()).encode(authRequest.getPassword()),new HashSet<Role>(Arrays.asList(role)));
        try {
            userRepo.save(user);
        } catch (Exception ex) {
            throw new Exception("Duplicate username");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
    
    
}
