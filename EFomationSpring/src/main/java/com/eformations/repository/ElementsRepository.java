package com.eformations.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eformations.entities.Elements;

@Repository
public interface ElementsRepository extends MongoRepository<Elements,String> {

	ArrayList<Elements> findByIdIn(List<String> elementsIds);
	
	Optional<Elements> findById(String elementsId);
}