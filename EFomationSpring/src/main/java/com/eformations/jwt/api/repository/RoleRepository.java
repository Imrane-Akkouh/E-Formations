package com.eformations.jwt.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eformations.jwt.api.entity.Roles;

public interface RoleRepository extends MongoRepository<Roles, String> {

    Roles findByRole(String role);
}