package com.h_shop.repository;

import com.h_shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail( String email);
}
