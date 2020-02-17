package com.fly.crmanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fly.crmanagement.entity.*;
import com.fly.crmanagement.entity.common.PageResult;
import com.fly.crmanagement.entity.common.Result;
import com.fly.crmanagement.entity.common.StatusCode;
import com.fly.crmanagement.service.ReserveService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 预约教室controller
 */
@RestController
@CrossOrigin
@RequestMapping("/reserve")
public class ReserveController {

    @Resource
    private ReserveService reserveService;

    /**
     * 带分页查询教室日程
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result getScheduleList(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody ReserveVO vo) {
        IPage<ScheduleVO> pageData = reserveService.getScheduleList(page, size, vo);
        return new Result(true, StatusCode.OK, "搜索成功", new PageResult<>(pageData.getTotal(), pageData.getRecords()));
    }

    /**
     * 提交预约
     */
    @PostMapping(value = "/apply")
    public Result reserve(@RequestBody Record record) {
        reserveService.reserve(record);
        return new Result(true, StatusCode.OK, "提交成功，请等待审核");
    }

    /**
     * 带分页查询用户预约记录
     */
    @GetMapping(value = "/record/{uid}/{page}/{size}")
    public Result getRecordList(@PathVariable("page") int page, @PathVariable("size") int size, @PathVariable("uid") int uid) {
        IPage<RecordVO> pages = reserveService.getRecordList(page, size, uid);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<>(pages.getTotal(), pages.getRecords()));
    }

    /**
     * 撤销预约
     */
    @PutMapping(value = "/cancel/{id}")
    public Result cancel(@PathVariable("id") int id) {
        if (reserveService.cancel(id)) {
            return new Result(true, StatusCode.OK, "撤销成功");
        } else {
            return new Result(false, StatusCode.ERROR, "撤销失败");
        }
    }
}
