package com.example.demo;

import com.example.demo.model.VetCabinet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//@CrossOrigin(origins = "http://localhost:8081")
@RestController //makes this class to serve HTTP requests from clients
@Component

public class VeterinaryController {
    @Autowired
    VetRepository repo;

//    @Autowired
//    MyPostRepo post_repo;

    @GetMapping("/veterinaries") //handles GET HTTP Requests
    public ResponseEntity<List<VetCabinet>> fetchAllVeterinaries() {
        List<VetCabinet> cabinet = repo.findAll();
        if(cabinet.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cabinet, HttpStatus.OK);
    }
    @GetMapping("veterinaries/{id}")
    public ResponseEntity<VetCabinet> fetchVeterinaryById(@PathVariable("id") String id) {
        Optional<VetCabinet> cabinet = repo.findVeterinaryById(id);
        if(cabinet.isPresent()) {
            return new ResponseEntity<>(cabinet.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/veterinaries")//handles PUT HTTP Requests
    public ResponseEntity<VetCabinet> addVeterinary(@RequestBody VetCabinet u) {
        String name = u.getName();
        boolean found = false;
        Optional<VetCabinet> cabinet = repo.findUserByName(name);
        if(cabinet.isEmpty()) {

                repo.insert(u);

                System.out.println("All good");
                return new ResponseEntity<>(u, HttpStatus.CREATED);
            } else {
                System.out.println("Found many veterinaies with name " + u.getName());
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    @PutMapping("/veterinaries/{id}")
    public ResponseEntity<VetCabinet> updateVeterinary(@PathVariable("id") String id, @RequestBody VetCabinet u) {
        Optional<VetCabinet> cabinet = repo.findVeterinaryById(id);
        if(cabinet.isPresent()) {
            VetCabinet _cabinet = cabinet.get();
            _cabinet.setUser(u.getUser());
            _cabinet.setName(u.getName());
            _cabinet.setPhone(u.getPhone());
            _cabinet.setLocation(u.getLocation());
            return new ResponseEntity<>(repo.insert(_cabinet), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete_veterinaries")
    public ResponseEntity<HttpStatus> deleteVeterinary(@RequestParam String id) {
        try {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
