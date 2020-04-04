package com.eformations.jwt.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eformations.jwt.api.entity.Inscriptions;

@Repository
public interface InscriptionRepository extends MongoRepository< Inscriptions , String> {

		
}
