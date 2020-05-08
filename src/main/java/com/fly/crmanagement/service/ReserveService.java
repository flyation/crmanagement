package com.fly.crmanagement.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fly.crmanagement.dao.ReserveMapper;
import com.fly.crmanagement.dao.ScheduleMapper;
import com.fly.crmanagement.entity.*;
import com.fly.crmanagement.util.FlyUtil;
import com.fly.crmanagement.util.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 预约教室service
 */
@Service
@Transactional
public class ReserveService {

    @Resource
    private ReserveMapper reserveMapper;

    @Resource
    private ScheduleMapper scheduleMapper;

    @Resource
    private JwtUtil jwtUtil;

    public IPage<ScheduleVO> getScheduleRoomList(int page, int size, ReserveVO vo) {
        System.out.println(vo.getDate());
        return reserveMapper.getScheduleRoomList(new Page(page, size), vo);
    }

    public IPage<ScheduleVO> getScheduleSeatList(int page, int size, ReserveVO vo) {
        System.out.println(vo.getDate());
        return reserveMapper.getScheduleSeatList(new Page(page, size), vo);
    }

    public void reserve(Record record, String token) {
        record.setUid(Integer.parseInt(jwtUtil.parseJWT(token).getId()));
        record.setTime1(LocalDateTime.now());
        record.setTime2(LocalDateTime.now());
        record.setTime3(LocalDateTime.now());
        record.setType(true);
        reserveMapper.insert(record);
    }

    // 预约座位，无需审核，直接通过
    public void reserveSeat(Record record, String token) {
        record.setUid(Integer.parseInt(jwtUtil.parseJWT(token).getId()));
        record.setTime1(LocalDateTime.now());
        record.setTime2(LocalDateTime.now());
        record.setTime3(LocalDateTime.now());
        record.setType(false);
        record.setChecked("通过");
        record.setReason("预约教室");
        reserveMapper.insert(record);

        //锁定教室日程表里选中的时间段
        //通过cid和date查出对应的那条教室日程实体
        Schedule schedule = scheduleMapper.selectByCidAndDate(record.getCid(), record.getDate());
        //更新课程时间段
        FlyUtil.Record2ScheduleBySeat(record, schedule);
        QueryWrapper<Schedule> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("id", schedule.getId());
        scheduleMapper.update(schedule, wrapper1);
    }

    public IPage<RecordVO> getRecordList(int page, int size, String token) {
        int uid = Integer.parseInt(jwtUtil.parseJWT(token).getId());
        return reserveMapper.getRecordList(new Page(page, size), uid);
    }

    public boolean cancel(int id) {
        QueryWrapper<Record> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        Record record = new Record();
        record.setCancel(true);
        record.setTime3(LocalDateTime.now());
        int update = reserveMapper.update(record, wrapper);

        //释放教室日程表里选中的时间段
        //通过id查出该条预约实体，再通过预约实体中的cid和date查出对应的那条教室日程实体
        Record recordInDB = reserveMapper.selectById(id);
        Schedule schedule = scheduleMapper.selectByCidAndDate(recordInDB.getCid(), recordInDB.getDate());
        //判断预约类型
        if (!recordInDB.getType()) {
            //预约座位
            //更新课程时间段
            FlyUtil.Record2ScheduleCancelBySeat(recordInDB, schedule);
            QueryWrapper<Schedule> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("id", schedule.getId());
            scheduleMapper.update(schedule, wrapper1);
        } else {
            //预约教室
            //更新课程时间段
            FlyUtil.Record2ScheduleCancel(recordInDB, schedule);
            QueryWrapper<Schedule> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("id", schedule.getId());
            scheduleMapper.update(schedule, wrapper1);
        }
        return update == 1;
    }
}
