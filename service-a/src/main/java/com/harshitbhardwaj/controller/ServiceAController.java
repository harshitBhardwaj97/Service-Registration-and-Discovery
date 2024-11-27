package com.harshitbhardwaj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAController {

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world from Service A!";
    }
}
