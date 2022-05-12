package com.example.demo;


import com.example.demo.model.User;
import com.example.demo.model.VetCabinet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VetRepository extends MongoRepository<VetCabinet, String> {
    Optional<VetCabinet> findVeterinaryById(String id);

    Optional<VetCabinet> findUserByName(String name);
}
