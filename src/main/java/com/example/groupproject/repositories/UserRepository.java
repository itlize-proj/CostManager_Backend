package com.example.groupproject.repositories;

import com.example.groupproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUserId(Integer userId);
    Optional<User> findUserByEmail(String email);
}
