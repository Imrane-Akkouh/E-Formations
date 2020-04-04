package com.eformations.jwt.api.service;

import com.eformations.jwt.api.entity.Roles;
import com.eformations.jwt.api.entity.Users;
import com.eformations.jwt.api.repository.RoleRepository;
import com.eformations.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = repository.findByUsername(username);
        if(users != null) {
        	
            List<GrantedAuthority> authorities = getUserAuthority(users.getRoles());
            
            return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(), authorities);
        } else {
        	return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(), new ArrayList<>());
        }
    }
    
    private List<GrantedAuthority> getUserAuthority(Set<Roles> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }
}
