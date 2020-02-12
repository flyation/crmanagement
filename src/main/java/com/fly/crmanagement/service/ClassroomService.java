package com.fly.crmanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fly.crmanagement.dao.ClassroomMapper;
import com.fly.crmanagement.entity.Classroom;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 教室信息service
 */
@Service
@Transactional
public class ClassroomService {

    @Resource
    private ClassroomMapper classroomMapper;

    public List<Classroom> findAll() {
        return classroomMapper.selectList(null);
    }

    public Classroom findById(String id) {
        return classroomMapper.selectById(id);
    }

    public void save(Classroom classroom) {
        classroomMapper.insert(classroom);
    }

    public void update(Classroom classroom) {
        classroomMapper.updateById(classroom);
    }

    public void deleteById(String id) {
        classroomMapper.deleteById(id);
    }

    public IPage<Classroom> findAll_Page(int page, int size) {
        return classroomMapper.findAll_Page(new Page(page, size));
    }
}
