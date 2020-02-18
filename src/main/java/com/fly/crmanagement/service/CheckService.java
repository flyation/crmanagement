package com.fly.crmanagement.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fly.crmanagement.dao.ReserveMapper;
import com.fly.crmanagement.dao.ScheduleMapper;
import com.fly.crmanagement.entity.Record;
import com.fly.crmanagement.entity.RecordVO;
import com.fly.crmanagement.entity.Schedule;
import com.fly.crmanagement.util.FlyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 审核预约service
 */
@Service
@Transactional
public class CheckService {

    @Resource
    private ReserveMapper reserveMapper;

    @Resource
    private ScheduleMapper scheduleMapper;

    public IPage<RecordVO> getReserveList(int page, int size) {
        return reserveMapper.getReserveList(new Page(page, size));
    }

    public String check(int id, boolean flag) {
        QueryWrapper<Record> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        Record record = new Record();
        record.setTime2(LocalDateTime.now());
        if (flag) {
            record.setChecked("通过");
            reserveMapper.update(record, wrapper);

            //锁定教室日程表里选中的时间段
            //通过id查出该条预约实体，再通过预约实体中的cid和date查出对应的那条教室日程实体
            Record recordInDB = reserveMapper.selectById(id);
            Schedule schedule = scheduleMapper.selectByCidAndDate(recordInDB.getCid(), recordInDB.getDate());
            //更新课程时间段
            FlyUtil.Record2Schedule(recordInDB, schedule);
            QueryWrapper<Schedule> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("id", schedule.getId());
            scheduleMapper.update(schedule, wrapper1);
            return "已通过";
        } else {
            record.setChecked("否决");
            reserveMapper.update(record, wrapper);
            return "已否决";
        }
    }
}
