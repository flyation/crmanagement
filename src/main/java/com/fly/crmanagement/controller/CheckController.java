package com.fly.crmanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fly.crmanagement.entity.Classroom;
import com.fly.crmanagement.entity.RecordVO;
import com.fly.crmanagement.entity.common.PageResult;
import com.fly.crmanagement.entity.common.Result;
import com.fly.crmanagement.entity.common.StatusCode;
import com.fly.crmanagement.service.CheckService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 审核预约controller
 */
@RestController
@CrossOrigin
@RequestMapping("/check")
public class CheckController {

    @Resource
    private CheckService checkService;

    /**
     * 带分页查询所有预约申请
     */
    @GetMapping(value = "/all/{page}/{size}")
    public Result getReserveList(@PathVariable("page") int page, @PathVariable("size") int size) {
        IPage<RecordVO> pages = checkService.getReserveList(page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<RecordVO>(pages.getTotal(), pages.getRecords()));
    }

    /**
     * 对预约进行审核
     */
    @PutMapping(value = "/{id}")
    public Result check(@PathVariable("id") int id, @RequestParam("flag") boolean flag) {
        return new Result(true, StatusCode.OK, checkService.check(id, flag));
    }

    /**
     * 按id查询
     */
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable("id") String cid) {
//        return new Result(true, StatusCode.OK, "查询成功", classroomService.findById(cid));
        return null;
    }
}
