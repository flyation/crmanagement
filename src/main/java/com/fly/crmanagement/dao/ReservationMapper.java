package com.fly.crmanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fly.crmanagement.entity.Classroom;
import com.fly.crmanagement.entity.Reservation;
import org.apache.ibatis.annotations.Select;

/**
 * 预约教室mapper
 */
public interface ReservationMapper extends BaseMapper<Reservation> {

}
