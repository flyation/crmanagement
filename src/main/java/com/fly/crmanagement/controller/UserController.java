package com.fly.crmanagement.controller;

import org.springframework.web.bind.annotation.*;

/**
 * vueAdmin-template-master 登录模块
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public String login() {
        System.out.println("login...");
        return "{\n" +
                "    \"code\": 20000,\n" +
                "    \"data\": {\n" +
                "        \"token\": \"admin\"\n" +
                "    }\n" +
                "}";
    }

    @GetMapping("/info")
    public String getInfo() {
        System.out.println("getInfo...");
        return "{\n" +
                "    \"code\": 20000,\n" +
                "    \"data\": {\n" +
                "        \"roles\": [\n" +
                "            \"admin\"\n" +
                "        ],\n" +
                "        \"name\": \"admin\",\n" +
                "        \"avatar\": \"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif\"\n" +
                "    }\n" +
                "}";
    }

    @PostMapping("/logout")
    public String logout() {
        System.out.println("logout...");
        return "{\n" +
                "    \"code\": 20000,\n" +
                "    \"data\": \"success\"\n" +
                "}";
    }
}
