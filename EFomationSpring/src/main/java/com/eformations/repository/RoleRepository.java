package com.eformations.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eformations.entities.Roles;

public interface RoleRepository extends MongoRepository<Roles, String> {

    Roles findByRole(String role);
}