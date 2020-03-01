package com.fly.crmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

/**
 * 用户DTO
 */
@Data
public class UserDTO {
    private Integer id;                 //主键
    private String username;            //用户名
    private String name;                //姓名
    private String avatar;              //头像
    private List<String> roles;         //角色
    private String token;               //token
}
