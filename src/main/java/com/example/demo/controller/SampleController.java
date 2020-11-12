package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sample")
@Slf4j
public class SampleController {

    @GetMapping("")
    public String get() {
        return "Sample";
    }

    @GetMapping("/test")
    public String getTest() {
        return "Sample test";
    }

}
