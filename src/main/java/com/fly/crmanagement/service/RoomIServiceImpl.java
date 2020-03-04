package com.fly.crmanagement.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fly.crmanagement.dao.ClassroomMapper;
import com.fly.crmanagement.entity.Classroom;
import org.springframework.stereotype.Service;

/**
 * 用于做批量插入操作
 */
@Service
public class RoomIServiceImpl extends ServiceImpl<ClassroomMapper, Classroom> implements RoomIService {

}
