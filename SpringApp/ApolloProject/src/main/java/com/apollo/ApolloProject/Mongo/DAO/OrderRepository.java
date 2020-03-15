package com.apollo.ApolloProject.Mongo.DAO;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.apollo.ApolloProject.Bean.Order;

@Repository
public interface OrderRepository  extends MongoRepository<Order, Long> {

	  public Order findByName(String name);

	}