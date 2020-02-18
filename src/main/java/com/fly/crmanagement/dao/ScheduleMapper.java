package com.fly.crmanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fly.crmanagement.entity.Schedule;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;

/**
 * 教室日程mapper
 */
public interface ScheduleMapper extends BaseMapper<Schedule> {
    @Select("select * from schedule where cid = #{cid} and date = #{date}")
    Schedule selectByCidAndDate(int cid, LocalDate date);
}
