package com.fly.crmanagement.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fly.crmanagement.dao.ReserveMapper;
import com.fly.crmanagement.entity.Record;
import com.fly.crmanagement.entity.RecordVO;
import com.fly.crmanagement.entity.ReserveVO;
import com.fly.crmanagement.entity.ScheduleVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 预约教室service
 */
@Service
@Transactional
public class ReserveService {

    @Resource
    private ReserveMapper reserveMapper;

    public IPage<ScheduleVO> getScheduleList(int page, int size, ReserveVO vo) {
        return reserveMapper.getScheduleList(new Page(page, size), vo);
    }

    public void reserve(Record record) {
        reserveMapper.insert(record);
    }

    public IPage<RecordVO> getRecordList(int page, int size, int uid) {
        uid = 2200;
        return reserveMapper.getRecordList(new Page(page, size), uid);
    }

    public boolean cancel(int id) {
        QueryWrapper<Record> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        Record record = new Record();
        record.setCancel(true);
        int update = reserveMapper.update(record, wrapper);
        return update == 1;
    }
}
