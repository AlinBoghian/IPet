package com.example.demo;

import com.example.demo.model.Sighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController //makes this class to serve HTTP requests from clients
@Component

public class SightingController {
    @Autowired
    SightingRepository repo;

    @GetMapping("/sightings") //handles GET HTTP Requests
    public ResponseEntity<List<Sighting>> fetchAllSightings() {
        List<Sighting> sightings = repo.findAll();
        if(sightings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sightings, HttpStatus.OK);
    }
    @GetMapping("sightings/{id}")
    public ResponseEntity<Sighting> fetchSightingById(@PathVariable("id") String id) {
        Optional<Sighting> sighting = repo.findSightingById(id);
        if(sighting.isPresent()) {
            return new ResponseEntity<>(sighting.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/sightings")//handles PUT HTTP Requests
    public ResponseEntity<Sighting> addSighting(@RequestBody Sighting u) {
        repo.insert(u);
        return new ResponseEntity<>(u, HttpStatus.CREATED);

    }
    @PutMapping("/sightings/{id}")
    public ResponseEntity<Sighting> updateSighting(@PathVariable("id") String id, @RequestBody Sighting u) {
        Optional<Sighting> sighting = repo.findSightingById(id);
        if(sighting.isPresent()) {
            Sighting _sighting = sighting.get();
            _sighting.setUser(u.getUser());
            _sighting.setLost(u.getLost());
            _sighting.setLocation(u.getLocation());

            return new ResponseEntity<>(repo.insert(_sighting), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deleteSightings")
    public ResponseEntity<HttpStatus> deleteSighting(@RequestParam String id) {
        try {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
