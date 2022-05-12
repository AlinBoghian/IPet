package com.example.demo;

import com.example.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository
        extends MongoRepository<User, String> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserById(String id);
}
