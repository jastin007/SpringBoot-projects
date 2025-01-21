package com.logic.tamil.security.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logic.tamil.security.jwt.Entity.User;

public interface UserRepository extends JpaRepository {
    Optional<User> findByUsername(String username);
}
