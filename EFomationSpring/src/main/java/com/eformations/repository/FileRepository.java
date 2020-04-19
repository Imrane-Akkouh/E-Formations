package com.eformations.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eformations.entities.File;


public interface FileRepository extends MongoRepository<File, String> { 
	File findByName(String name);
}

