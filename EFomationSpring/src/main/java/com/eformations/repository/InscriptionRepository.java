package com.eformations.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.eformations.entities.Inscriptions;

@Repository
public interface InscriptionRepository extends MongoRepository<Inscriptions, String> {

	
}
