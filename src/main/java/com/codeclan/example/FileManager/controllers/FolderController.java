package com.codeclan.example.FileManager.controllers;

import com.codeclan.example.FileManager.models.Folder;
import com.codeclan.example.FileManager.models.User;
import com.codeclan.example.FileManager.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders() {
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity<Optional<Folder>> getFolderById(@PathVariable Long id) {
        Optional<Folder> payload = folderRepository.findById(id);
        if (payload.isPresent()) {
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> createFolder(@RequestBody Folder folder) {
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.OK);
    }

}
