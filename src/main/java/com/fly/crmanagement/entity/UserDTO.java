package com.fly.crmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 用户DTO
 */
@Data
public class UserDTO {
    @TableId(type = IdType.AUTO)
    private Integer id;         //主键
    private String username;    //用户名
    private String password;    //密码
    private String roles;        //角色
    private String token;       //token
    private String name;       //name
    private String avatar;       //avatar
}
