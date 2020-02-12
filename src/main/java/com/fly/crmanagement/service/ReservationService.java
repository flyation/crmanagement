package com.fly.crmanagement.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fly.crmanagement.dao.ClassroomMapper;
import com.fly.crmanagement.dao.ReservationMapper;
import com.fly.crmanagement.dao.ScheduleMapper;
import com.fly.crmanagement.entity.Classroom;
import com.fly.crmanagement.entity.Reservation;
import com.fly.crmanagement.entity.ReservationVO;
import com.fly.crmanagement.entity.Schedule;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 预约教室service
 */
@Service
@Transactional
public class ReservationService {

    @Resource
    private ScheduleMapper scheduleMapper;

    public IPage<Schedule> getPageList(int page, int size, ReservationVO vo) {
        System.out.println("service...");
        // 无查询条件时查询所有
        if (null == vo.getDate()) {
            return scheduleMapper.getPageList(new Page(page, size));
        }

        // 有查询条件时根据条件查询空闲教室
        QueryWrapper<Schedule> wrapper = new QueryWrapper<>();
        wrapper.ge("capacity", vo.getCapacity());
        wrapper.eq("type", vo.getType());
        wrapper.eq("building", vo.getBuilding());
        wrapper.eq("date", vo.getDate());
        //course1
        if ((vo.getCourse1() != null) && (vo.getCourse1())) {
            wrapper.eq("course1", 0);
        }
        //course2
        if ((vo.getCourse2() != null) && (vo.getCourse2())) {
            wrapper.eq("course2", 0);
        }
        //course3
        if ((vo.getCourse3() != null) && (vo.getCourse3())) {
            wrapper.eq("course3", 0);
        }
        //course4
        if ((vo.getCourse4() != null) && (vo.getCourse4())) {
            wrapper.eq("course4", 0);
        }
        List<Schedule> schedules = scheduleMapper.selectList(wrapper);
        schedules.forEach(System.out::println);
        Page pages = new Page(page, size);
        pages.setRecords(schedules);
        return pages;
    }
}
