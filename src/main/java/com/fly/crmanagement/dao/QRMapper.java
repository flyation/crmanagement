package com.fly.crmanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fly.crmanagement.entity.Record;
import com.fly.crmanagement.entity.ScheduleVO;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;

/**
 *
 */
public interface QRMapper extends BaseMapper<Record> {

    @Select("<script>"
            + "SELECT * "
            + "FROM schedule t1 "
            + "LEFT JOIN classroom t2 ON t1.cid = t2.id "
            + "WHERE t1.cid = #{cid} "
            + "AND t1.date = #{date}"
            + "</script>")
    ScheduleVO getRoomSchedule(int cid, LocalDate date);
}
