package com.fly.crmanagement.controller;

import com.fly.crmanagement.entity.User;
import com.fly.crmanagement.entity.UserDTO;
import com.fly.crmanagement.entity.common.Result;
import com.fly.crmanagement.entity.common.StatusCode;
import com.fly.crmanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
        UserDTO userDTO = userService.login(user);
        if (null != userDTO) {
            return new Result(true, StatusCode.OK, "验证成功", userDTO);
        } else {
            return new Result(true, StatusCode.LOGINERROR, "验证失败，账号或密码错误");
        }
    }

    @GetMapping("/info")
    public Result getInfo(@RequestParam String token) {
        UserDTO userDTO = userService.getInfo(token);
        return new Result(true, StatusCode.OK, "验证成功", userDTO);
    }

    @PostMapping("/logout")
    public String logout() {
        return "{\n" +
                "    \"code\": 20000,\n" +
                "    \"data\": \"success\"\n" +
                "}";
    }

    @GetMapping("/all")
    public Result getUserList() {
        List<User> userList = userService.getUserList();
        return new Result(true, StatusCode.OK, "查询所有用户成功", userList);
    }

    @GetMapping("/{uid}")
    public Result getUser(@PathVariable("uid") int uid) {
        User user = userService.getUser(uid);
        return new Result(true, StatusCode.OK, "查询用户成功", user);
    }

    @PostMapping("/update")
    public Result getUser(@RequestBody User user) {
        userService.updateUser(user);
        return new Result(true, StatusCode.OK, "更新用户信息成功", user);
    }
}
