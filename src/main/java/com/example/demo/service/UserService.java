package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserJpaRepository;

@Service
public class UserService {
    @Autowired
    private UserJpaRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByUserId(Long userId) {
        return userRepository.findByUserId(userId);
    }

    public User save() {
        User user = User.builder()
                .uid("test" + System.currentTimeMillis() + "@gmail.com")
                .name("테스트")
                .build();
        return userRepository.save(user);
    }

}
