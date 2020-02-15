package com.fly.crmanagement.util;

import com.fly.crmanagement.entity.User;
import com.fly.crmanagement.entity.UserDTO;

import java.util.ArrayList;

public class UserUtil {

    public static UserDTO User2UserDTO (User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setName(user.getName());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setToken(user.getToken());

        ArrayList<String> roles = new ArrayList<>();
        roles.add(user.getRole());
        userDTO.setRoles(roles);

        return userDTO;
    }
}
