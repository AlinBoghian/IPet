package com.example.demo.Registration.token;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends MongoRepository<ConfirmationToken, Long> {
    Optional<ConfirmationToken> findByToken(String token);
}
