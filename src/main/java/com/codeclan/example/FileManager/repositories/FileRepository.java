package com.codeclan.example.FileManager.repositories;

import com.codeclan.example.FileManager.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
