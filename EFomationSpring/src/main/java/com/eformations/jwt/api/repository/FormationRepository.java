package com.eformations.jwt.api.repository;

import com.eformations.jwt.api.entity.Formations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends MongoRepository<Formations,String> {

	ArrayList<Formations> findAllById(List<String> formationIds);
}