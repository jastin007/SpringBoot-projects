package com.logic.tamil.security.jwt.repository;

import java.util.Optional;

import com.logic.tamil.security.jwt.Entity.Role;

public interface RoleRepository {
    Optional<Role> findByName(String Name);
}
