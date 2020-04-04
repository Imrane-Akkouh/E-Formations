package com.eformations.jwt.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eformations.jwt.api.entity.File;


public interface FileRepository extends MongoRepository<File, String> { 
	File findByName(String name);
}

