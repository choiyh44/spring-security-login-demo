package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "1.User" })
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "전체회원조회", notes = "1.전체회원을 조회한다.")
    @GetMapping(value = "")
    public List<User> findAlluser() {
        return userService.findAll();
    }

    @ApiOperation(value = "회원조회", notes = "2.회원아이디로 회원을 조회한다.")
    @GetMapping(value = "/{userId}")
    public User findAlluser(@PathVariable Long userId) {
        return userService.findByUserId(userId);
    }

    @ApiOperation(value = "회원등록", notes = "3.회원을 신규로 등록한다.")
    @PostMapping(value = "")
    public User user() {
        return userService.save();
    }

    @PostMapping(value = "/login")
    public User login() {
        return userService.save();
    }

    @PostMapping(value = "/logout")
    public User logout() {
        return userService.save();
    }

}
