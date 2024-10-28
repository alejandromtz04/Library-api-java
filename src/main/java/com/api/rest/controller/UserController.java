package com.api.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/createUser")
    public String createUser(){
        System.out.println("Solicitud ejecutada");
        return "Hello world";
    }
}
