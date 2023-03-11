package com.abhinavkum.cms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/test")
public class HelloWorld {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world";
    }
}
