package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repositoru.UserRepository;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //makes this class to serve HTTP requests from clients
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    @Autowired
    private final UserRepository repo;
    @GetMapping("/users") //handles GET HTTP Requests
    public ResponseEntity<List<User>> fetchAllUsers() {
        List<User> users = repo.findAll();
        if(users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("users/{id}")
    public List<User> fetchUserById(@PathVariable String id) {

    }
    @PostMapping("/users") //handles PUT HTTP Requests
    public ResponseEntity<User> addUser(User u) {
        String email = u.getEmail();
        repo.findUserByEmail(email).ifPresentOrElse(u -> {
            throw new IllegalStateException("found many users with email " + email);
        }, () -> {
            repo.insert(u);
        });
    }
    @PutMapping("/users")
    public ResponseEntity<User> updateUser(String id, User u) {
       
    }
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteUser(String id) {

    }
  //  @DeleteMapping //delete a user
}
