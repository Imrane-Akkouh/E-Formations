package com.apollo.ApolloProject.Mongo.DAO;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.apollo.ApolloProject.Bean.Environment;

@Repository
public interface EnvironmentRepository extends MongoRepository<Environment, Long> {

	  public Environment findByName(String name);

	}
