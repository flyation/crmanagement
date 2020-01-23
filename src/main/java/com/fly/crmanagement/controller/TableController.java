package com.fly.crmanagement.controller;

import org.springframework.web.bind.annotation.*;

/**
 * vueAdmin-template-master Table
 */
@RestController
@CrossOrigin
@RequestMapping("/table")
public class TableController {

    @GetMapping("/list")
    public String login() {
        return "{\"code\":20000,\"data\":{\"token\":\"admin\"}}";
    }
}
