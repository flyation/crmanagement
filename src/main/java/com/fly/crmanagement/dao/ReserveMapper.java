package com.fly.crmanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fly.crmanagement.entity.Record;
import com.fly.crmanagement.entity.RecordClassroom;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 预约教室mapper
 */
public interface ReserveMapper extends BaseMapper<Record> {

    @Select("select * from reserve left join classroom on reserve.cid = classroom.id where uid = #{uid} and cancel = 0")
    IPage<RecordClassroom> getUserRecordList(Page page, @Param("uid")int uid);
}
