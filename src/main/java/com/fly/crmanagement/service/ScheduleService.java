package com.fly.crmanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fly.crmanagement.dao.ScheduleMapper;
import com.fly.crmanagement.entity.Classroom;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class ScheduleService {

    @Resource
    private ScheduleMapper scheduleMapper;

}
