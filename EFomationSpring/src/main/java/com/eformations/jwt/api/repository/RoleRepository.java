package com.eformations.jwt.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eformations.jwt.api.entity.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);
}