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
import java.util.Optional;

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
    @PostMapping("/users") //handles PUT HTTP Requests
    public ResponseEntity<User> addUser(@RequestBody User u) {
        String email = u.getEmail();
        boolean found = false;
        Optional<User> user = repo.findUserByEmail(email);
        if(user.isEmpty()) {
            repo.insert(u);
            return new ResponseEntity<>(u, HttpStatus.CREATED);
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
           _user.setState(u.getState());
           return new ResponseEntity<>(repo.insert(_user), HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id) {
        try {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
  //  @DeleteMapping //delete a user
}
