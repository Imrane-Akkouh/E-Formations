package com.eformations.services;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
=======
import com.eformations.entities.Roles;
import com.eformations.entities.Users;
import com.eformations.repository.UserRepository;
>>>>>>> 3371eb343fe96b147a9c8ccd748007f193c87066

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eformations.entities.Roles;
import com.eformations.entities.Users;
import com.eformations.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {
	
    @Autowired
    private UserRepository repository;
<<<<<<< HEAD
//    @Autowired
//    private RoleRepository roleRepository;
    
    @SuppressWarnings("null")
	@Override
=======

    @Override
>>>>>>> 3371eb343fe96b147a9c8ccd748007f193c87066
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
