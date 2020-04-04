package com.eformations.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eformations.entities.Users;

@Repository
public interface UserRepository extends MongoRepository<Users,String> {
	
    Users findByUsername(String username);

}
