package com.formation.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.formation.bean.Formateur;

@Repository
public interface FormationRepository  extends MongoRepository<Formateur, Long> {

	  public Formateur findByName(String name);

	}