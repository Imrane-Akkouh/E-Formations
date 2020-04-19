package com.eformations.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eformations.entities.Formations;

@Repository
public interface FormationRepository extends MongoRepository<Formations,String> {

	ArrayList<Formations> findByIdIn(List<String> formationIds);
	
	Optional<Formations> findById(String formationId);
	
	ArrayList<Formations> findByDateBetween(Date startDate, Date endDate);
}