package com.codeclan.example.FileManager.controllers;

import com.codeclan.example.FileManager.models.User;
import com.codeclan.example.FileManager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        Optional<User> payload = userRepository.findById(id);
        if (payload.isPresent()) {
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
