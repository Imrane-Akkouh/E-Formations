package com.eformations.jwt.api;

import com.eformations.jwt.api.entity.Users;
import com.eformations.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringEformationsApplication {
	/*@Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "eformations", "password", "BENEFICIAIRE"),
                new User(102, "imrane", "123", "FORMATEUR"),
                new User(103, "user2", "pwd2", "BENEFICIAIRE"),
                new User(104, "user3", "pwd3", "BENEFICIAIRE")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(SpringEformationsApplication.class, args);
    }

}
