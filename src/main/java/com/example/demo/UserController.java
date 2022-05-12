package com.example.demo;

import com.example.demo.model.User;
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

public class UserController {
    @Autowired
    MyRepository repo;

//    @Autowired
//    MyPostRepo post_repo;

    @GetMapping("/users") //handles GET HTTP Requests
    public ResponseEntity<List<User>> fetchAllUsers() {
        List<User> users = repo.findAll();
        if(users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("users/{id}")
    public ResponseEntity<User> fetchUserById(@PathVariable("id") String id) {
        Optional<User> user = repo.findUserById(id);
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/users")//handles PUT HTTP Requests
    public ResponseEntity<User> addUser(@RequestBody User u) {
        String email = u.getEmail();
        boolean found = false;
        Optional<User> user = repo.findUserByEmail(email);
        if(user.isEmpty()) {
            user = repo.findUserByUsername(u.getUsername());
            if(user.isEmpty()) {
                repo.insert(u);

                System.out.println("All good");
                return new ResponseEntity<>(u, HttpStatus.CREATED);
            } else {
                System.out.println("Found many users with username " + u.getUsername());
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            System.out.println("Found many users with email " + email);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User u) {
       Optional<User> user = repo.findUserById(id);
       if(user.isPresent()) {
           User _user = user.get();
           _user.setEmail(u.getEmail());
           _user.setUsername(u.getUsername());
           _user.setPasswd(u.getPasswd());
           _user.setType(u.getType());
           return new ResponseEntity<>(repo.insert(_user), HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteUser(@RequestParam String id) {
        try {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
