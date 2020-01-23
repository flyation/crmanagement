package com.fly.crmanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fly.crmanagement.entity.Classroom;
import com.fly.crmanagement.entity.PageResult;
import com.fly.crmanagement.entity.Result;
import com.fly.crmanagement.entity.StatusCode;
import com.fly.crmanagement.service.ClassroomService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/classroom")
public class ClassroomController {

    @Resource
    private ClassroomService classroomService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", classroomService.findAll());
    }

    /**
     * 带分页查询所有
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/all/{page}/{size}")
    public Result findAll_Page(@PathVariable("page") int page, @PathVariable("size") int size) {
        IPage<Classroom> pageData = classroomService.findAll_Page(page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Classroom>(pageData.getTotal(), pageData.getRecords()));
    }

    /**
     * 按id查询
     * @param cid
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable("id") String cid) {
        return new Result(true, StatusCode.OK, "查询成功", classroomService.findById(cid));
    }

    /**
     * 新增
     * @param classroom
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Classroom classroom) {
        System.out.println(classroom);
        classroomService.save(classroom);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改
     * @param id
     * @param classroom
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable("id") String id, @RequestBody Classroom classroom) {
        classroomService.update(classroom);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    /**
     * 删除单个
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result deleteById(@PathVariable("id") String id) {
        classroomService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
