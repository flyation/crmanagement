package com.fly.crmanagement.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fly.crmanagement.dao.UserMapper;
import com.fly.crmanagement.entity.User;
import com.fly.crmanagement.entity.UserDTO;
import com.fly.crmanagement.util.FlyUtil;
import com.fly.crmanagement.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户service
 */
@Service
@Transactional
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private JwtUtil jwtUtil;

    public UserDTO login(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        wrapper.eq("password", user.getPassword());
        User userLogin = userMapper.selectOne(wrapper);
        if (null != userLogin) {
            String token = jwtUtil.createJWT(userLogin.getId().toString(), userLogin.getUsername(), userLogin.getRole());
            UserDTO userDTO = FlyUtil.User2UserDTO(userLogin);
            userDTO.setToken(token);
            return userDTO;
        } else {
            return null;
        }
    }

    public UserDTO getInfo(String token) {
        //通过token验证用户，再在数据库中查询用户的权限
        Claims claims = jwtUtil.parseJWT(token);
        String id = claims.getId();
        if (null != id) {
            User user = userMapper.selectById(Integer.parseInt(id));
            UserDTO userDTO = FlyUtil.User2UserDTO(user);
            return userDTO;
        } else {
            return null;
        }
    }

    public List<User> getUserList() {
        return userMapper.selectList(null);
    }

    public User getUser(int uid) {
        return userMapper.selectById(uid);
    }

    public void updateUser(User user) {
        userMapper.updateById(user);
    }
}
