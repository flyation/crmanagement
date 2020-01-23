package com.fly.crmanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fly.crmanagement.entity.Classroom;
import org.apache.ibatis.annotations.Select;

/**
 * 教室生成器
 */
public interface ClassroomFactoryMapper extends BaseMapper<Classroom> {

}
