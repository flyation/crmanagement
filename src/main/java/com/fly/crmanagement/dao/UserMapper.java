package com.fly.crmanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fly.crmanagement.entity.Schedule;
import com.fly.crmanagement.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * 用户mapper
 */
public interface UserMapper extends BaseMapper<User> {
}
