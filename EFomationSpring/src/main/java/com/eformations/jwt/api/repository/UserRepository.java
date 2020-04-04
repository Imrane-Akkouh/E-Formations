package com.eformations.jwt.api.repository;

import com.eformations.jwt.api.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Users,String> {
    Users findByUsername(String username);
}
