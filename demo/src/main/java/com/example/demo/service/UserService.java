package com.example.demo.service;

import com.example.demo.repositoru.UserRepository;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    @Autowired
    private final UserRepository repo;
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public List<User> getUserBuId(String id) {
        return repo.findUserById(id);
    }

    public ResponseEntity<User> addUser(User u) {
        return null;
    }

    public ResponseEntity<User> updateUser(String id, User u) {
        return null;
    }

    public ResponseEntity<HttpStatus> deleteUser(String id) {
        return null;
    }
}
