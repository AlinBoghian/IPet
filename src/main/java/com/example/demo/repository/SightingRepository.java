package com.example.demo.repository;

import com.example.demo.model.Sighting;
import com.example.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SightingRepository extends MongoRepository<Sighting, String> {
    Optional<Sighting> findSightingById(String id);
}
