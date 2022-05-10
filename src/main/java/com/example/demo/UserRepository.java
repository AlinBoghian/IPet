package com.example.demo;

import com.example.demo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserRepository
        extends MongoRepository<User, String> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserById(String id);
}
