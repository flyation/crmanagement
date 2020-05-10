package com.fly.crmanagement.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fly.crmanagement.dao.ScheduleMapper;
import com.fly.crmanagement.entity.Schedule;
import org.springframework.stereotype.Service;

/**
 * 用于做批量插入操作
 */
@Service
public class ScheduleIServiceImpl extends ServiceImpl<ScheduleMapper, Schedule> implements ScheduleIService {

}
