package com.formation.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.formation.bean.Formation;

@Repository
public interface FormateurRepository extends MongoRepository<Formation, Long> {

	  public Formation findByName(String name);

	}
