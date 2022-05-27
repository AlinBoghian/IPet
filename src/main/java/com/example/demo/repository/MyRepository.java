package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface MyRepository
        extends MongoRepository<User, String> {
//    @Query("{email:'?0'}")
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserById(String id);

    Optional<User> findUserByUsername(String username);
}
