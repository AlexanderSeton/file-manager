package com.codeclan.example.FileManager.repositories;

import com.codeclan.example.FileManager.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
