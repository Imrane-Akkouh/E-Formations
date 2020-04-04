package com.eformations.jwt.api.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eformations.jwt.api.entity.AuthRequest;
import com.eformations.jwt.api.entity.Formations;
import com.eformations.jwt.api.entity.Roles;
import com.eformations.jwt.api.entity.User;
import com.eformations.jwt.api.repository.FormationRepository;
import com.eformations.jwt.api.repository.RoleRepository;
import com.eformations.jwt.api.repository.UserRepository;
import com.eformations.jwt.api.util.JwtUtil;

@RestController
@CrossOrigin
public class AuthController {
	@Autowired
    private UserRepository userRepo;
	@Autowired
    private RoleRepository roleRepo;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private FormationRepository formationRepository;
    
    @GetMapping("/")
    public String welcome() {
        return "Welcome to eformations !!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
    
    @PostMapping("/register")
    public String register(@RequestBody AuthRequest authRequest) throws Exception {
        Roles role = roleRepo.findByRole(authRequest.getRole());
        User user = new User(authRequest.getUsername(), (new BCryptPasswordEncoder()).encode(authRequest.getPassword()),new HashSet<Roles>(Arrays.asList(role)));
        
        System.out.println(authRequest.getUsername() + " " + (new BCryptPasswordEncoder()).encode(authRequest.getPassword()) + " " + authRequest.getRole());
        userRepo.save(user);
        return jwtUtil.generateToken(authRequest.getUsername());
    }
    
    @RequestMapping(value = "/formations", method = RequestMethod.GET)
    public List<Formations> getFormation(@RequestHeader (name="Authorization") String token) {
    	
    	return formationRepository.findAll();
    }    
    
}
