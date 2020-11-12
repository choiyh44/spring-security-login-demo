package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    public User findByUserId(Long userId);
}
