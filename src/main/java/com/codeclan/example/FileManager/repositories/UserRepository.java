package com.codeclan.example.FileManager.repositories;

import com.codeclan.example.FileManager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
