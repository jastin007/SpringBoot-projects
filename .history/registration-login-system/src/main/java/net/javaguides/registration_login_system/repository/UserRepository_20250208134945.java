package net.javaguides.registration_login_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.registration_login_system.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
