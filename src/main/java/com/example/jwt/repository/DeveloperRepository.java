package com.example.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt.model.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    Developer findByUsername(String username);
}