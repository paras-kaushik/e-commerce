package com.investment.e_commerce.dao;

import com.investment.e_commerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    // Custom finder method to find a user by email
    Optional<User> findByEmail(String email);
}
