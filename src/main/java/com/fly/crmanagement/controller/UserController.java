package com.fly.crmanagement.controller;

import com.fly.crmanagement.entity.Result;
import com.fly.crmanagement.entity.StatusCode;
import com.fly.crmanagement.entity.User;
import com.fly.crmanagement.entity.UserDTO;
import com.fly.crmanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * vueAdmin-template-master 登录模块
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        System.out.println("login..." + user);
        User userInDB = userService.login(user);
        if (null != userInDB) {
            UserDTO userDTO = new UserDTO();
            userDTO.setToken(userInDB.getRole() + "Token");
            return new Result(true, StatusCode.OK, "验证成功", userDTO);
        } else {
            return new Result(true, StatusCode.LOGINERROR, "验证失败");
        }
//        return "{\n" +
//                "    \"code\": 20000,\n" +
//                "    \"data\": {\n" +
//                "        \"token\": \"admin\"\n" +
//                "    }\n" +
//                "}";
    }

    @GetMapping("/info")
    public Result getInfo(@RequestParam String token) {
        System.out.println("getInfo...");
        System.out.println("token = " + token);
        UserDTO userDTO = userService.getInfo(token);
        return new Result(true, StatusCode.OK, "验证成功", userDTO);
//        return "{\n" +
//                "    \"code\": 20000,\n" +
//                "    \"data\": {\n" +
//                "        \"roles\": [\n" +
//                "            \"admin\"\n" +
//                "        ],\n" +
//                "        \"name\": \"adminFly\",\n" +
//                "        \"avatar\": \"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif\"\n" +
//                "    }\n" +
//                "}";
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
