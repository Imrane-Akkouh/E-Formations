package com.eformations.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eformations.entities.Formations;

@Repository
public interface FormationRepository extends MongoRepository<Formations,String> {

	ArrayList<Formations> findAllById(List<String> formationIds);
}