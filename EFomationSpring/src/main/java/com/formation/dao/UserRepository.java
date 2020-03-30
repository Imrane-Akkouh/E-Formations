package com.formation.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.formation.bean.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	  public User findByEmail(String email);

	}
