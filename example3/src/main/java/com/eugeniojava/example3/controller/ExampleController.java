package com.eugeniojava.example3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @GetMapping("/hello")
    public String getHello() {
        return "Hello!";
    }
}
