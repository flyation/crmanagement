package com.fly.crmanagement.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fly.crmanagement.dao.UserMapper;
import com.fly.crmanagement.entity.User;
import com.fly.crmanagement.entity.UserDTO;
import com.fly.crmanagement.util.UserUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户service
 */
@Service
@Transactional
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User login(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        wrapper.eq("password", user.getPassword());
        return userMapper.selectOne(wrapper);
    }

    public UserDTO getInfo(String token) {
        // todo 通过token验证用户，再在数据库中查询用户的权限
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("token", token);
        User user = userMapper.selectOne(wrapper);

        UserDTO userDTO = UserUtil.User2UserDTO(user);
        return userDTO;
    }
}
