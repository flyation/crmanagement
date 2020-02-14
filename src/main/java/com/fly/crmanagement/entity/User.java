package com.fly.crmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 用户实体
 */
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;         //主键
    private String username;    //用户名
    private String password;    //密码
    private String role;        //角色
}
