package com.example.demo;

import com.example.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

//@Repository
public interface MyRepository
        extends MongoRepository<User, String> {
//    @Query("{email:'?0'}")
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserById(String id);

    Optional<User> findUserByUsername(String username);
}
