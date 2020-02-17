package com.fly.crmanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fly.crmanagement.entity.Classroom;
import com.fly.crmanagement.entity.common.PageResult;
import com.fly.crmanagement.entity.common.Result;
import com.fly.crmanagement.entity.common.StatusCode;
import com.fly.crmanagement.service.ClassroomService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 教室信息controller
 */
@RestController
@CrossOrigin
@RequestMapping("/classroom")
public class ClassroomController {

    @Resource
    private ClassroomService classroomService;

    /**
     * 查询所有
     */
    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", classroomService.findAll());
    }

    /**
     * 带分页查询所有
     */
    @GetMapping(value = "/all/{page}/{size}")
    public Result findAll_Page(@PathVariable("page") int page, @PathVariable("size") int size) {
        IPage<Classroom> pages = classroomService.findAll_Page(page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Classroom>(pages.getTotal(), pages.getRecords()));
    }

    /**
     * 按id查询
     */
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable("id") String cid) {
        return new Result(true, StatusCode.OK, "查询成功", classroomService.findById(cid));
    }

    /**
     * 新增
     */
    @PostMapping
    public Result save(@RequestBody Classroom classroom) {
        System.out.println(classroom);
        classroomService.save(classroom);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     */
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable("id") String id, @RequestBody Classroom classroom) {
        classroomService.update(classroom);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    /**
     * 删除单个
     */
    @DeleteMapping(value = "/{id}")
    public Result deleteById(@PathVariable("id") String id) {
        classroomService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
