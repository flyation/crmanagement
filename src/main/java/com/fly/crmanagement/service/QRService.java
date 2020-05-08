package com.fly.crmanagement.service;

import com.fly.crmanagement.dao.QRMapper;
import com.fly.crmanagement.entity.Record;
import com.fly.crmanagement.entity.ScheduleVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 二维码service
 */
@Service
@Transactional
public class QRService {

    @Resource
    private QRMapper qrMapper;

    public ScheduleVO getRoomSchedule(ScheduleVO vo) {
        ScheduleVO scheduleVO = qrMapper.getRoomSchedule(vo.getCid(), vo.getDate());
        return scheduleVO;
    }

    public void reserve(Record record, int uid) {
        // TODO: 2020/5/8 获取uid
        record.setUid(uid);
        record.setTime1(LocalDateTime.now());
        record.setTime2(LocalDateTime.now());
        record.setTime3(LocalDateTime.now());
        record.setType(true);
        qrMapper.insert(record);
    }
}
