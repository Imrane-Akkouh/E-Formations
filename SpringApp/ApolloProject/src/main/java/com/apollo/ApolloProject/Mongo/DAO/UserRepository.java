package com.apollo.ApolloProject.Mongo.DAO;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.apollo.ApolloProject.Bean.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	  public User findByEmail(String email);

	}
