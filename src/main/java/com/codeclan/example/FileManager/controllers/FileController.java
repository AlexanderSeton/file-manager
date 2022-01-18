package com.codeclan.example.FileManager.controllers;

import com.codeclan.example.FileManager.models.File;
import com.codeclan.example.FileManager.models.User;
import com.codeclan.example.FileManager.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllFiles() {
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity<Optional<File>> getFileById(@PathVariable Long id) {
        Optional<File> payload = fileRepository.findById(id);
        if (payload.isPresent()) {
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> createFile(@RequestBody File file) {
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.OK);
    }

}
