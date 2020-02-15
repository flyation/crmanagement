package com.fly.crmanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fly.crmanagement.entity.Schedule;
import org.apache.ibatis.annotations.Select;

/**
 * 教室日程mapper
 */
public interface ScheduleMapper extends BaseMapper<Schedule> {

    @Select("select * from schedule")
    IPage<Schedule> getPageList(Page page);

}
