package com.eformations.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eformations.entities.Elements;

@Repository
public interface ElementRepository extends MongoRepository<Elements, String> {

}
