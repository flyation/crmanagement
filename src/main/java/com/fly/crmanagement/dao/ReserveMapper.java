package com.fly.crmanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fly.crmanagement.entity.Record;
import com.fly.crmanagement.entity.RecordVO;
import com.fly.crmanagement.entity.ReserveVO;
import com.fly.crmanagement.entity.ScheduleVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 预约教室mapper
 */
public interface ReserveMapper extends BaseMapper<Record> {

    @Select("SELECT * FROM reserve "
            + "LEFT JOIN classroom ON reserve.cid = classroom.id "
            + "WHERE uid = #{uid} "
            + "ORDER BY time1 DESC")
    IPage<RecordVO> getRecordList(Page page, @Param("uid")int uid);

    @Select("<script>"
            + "SELECT * "
            + "FROM schedule t1 "
            + "LEFT JOIN classroom t2 ON t1.cid = t2.id "
            + "WHERE 1=1 "
            + "<if test='vo.date != null'>AND t1.date = #{vo.date} </if>"
            + "<if test='vo.course1 != null and vo.course1 == 1'>AND t1.course1 = 0 </if>"
            + "<if test='vo.course2 != null and vo.course2 == 1'>AND t1.course2 = 0 </if>"
            + "<if test='vo.course3 != null and vo.course3 == 1'>AND t1.course3 = 0 </if>"
            + "<if test='vo.course4 != null and vo.course4 == 1'>AND t1.course4 = 0 </if>"
            + "<if test='vo.capacity != null'>AND t2.capacity >= #{vo.capacity} </if>"
            + "<if test='vo.building != null'>AND t2.building = #{vo.building} </if>"
            + "<if test='vo.type != null'>AND t2.type = #{vo.type} </if>"
            + "</script>")
    IPage<ScheduleVO> getScheduleList(Page page, ReserveVO vo);

    @Select("SELECT * FROM reserve t1 "
            + "LEFT JOIN classroom t2 ON t1.cid = t2.id "
            + "LEFT JOIN user t3 ON t1.uid = t3.id "
            + "WHERE checked = '待审' AND cancel = 0")
    IPage<RecordVO> getReserveList(Page page);
}
