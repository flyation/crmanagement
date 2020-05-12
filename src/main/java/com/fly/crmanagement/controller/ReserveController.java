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
     * 带分页查询教室日程(预约教室)
     */
    @PostMapping(value = "/searchRoom/{page}/{size}")
    public Result getScheduleRoomList(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody ReserveVO vo) {
        IPage<ScheduleVO> pageData = reserveService.getScheduleRoomList(page, size, vo);
        return new Result(true, StatusCode.OK, "搜索成功", new PageResult<>(pageData.getTotal(), pageData.getRecords()));
    }

    /**
     * 带分页查询教室日程(预约座位)
     */
    @PostMapping(value = "/searchSeat/{page}/{size}")
    public Result getScheduleSeatList(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody ReserveVO vo) {
        IPage<ScheduleVO> pageData = reserveService.getScheduleSeatList(page, size, vo);
        return new Result(true, StatusCode.OK, "搜索成功", new PageResult<>(pageData.getTotal(), pageData.getRecords()));
    }

    /**
     * 提交预约（预约教室）
     */
    @PostMapping(value = "/apply")
    public Result reserve(@RequestBody Record record, @RequestHeader("X-token") String token) {
        reserveService.reserve(record, token);
        return new Result(true, StatusCode.OK, "提交成功，请等待审核");
    }

//    /**
//     * 提交预约（预约教室），通过二维码
//     */
//    @PostMapping(value = "/apply")
//    public Result reserveByQR(@RequestBody Record record) {
//        reserveService.reserveByQR(record);
//        return new Result(true, StatusCode.OK, "提交成功，请等待审核");
//    }

    /**
     * 预约座位
     */
    @PostMapping(value = "/applySeat")
    public Result reserveSeat(@RequestBody Record record, @RequestHeader("X-token") String token) {
        reserveService.reserveSeat(record, token);
        return new Result(true, StatusCode.OK, "预约座位成功");
    }

    /**
     * 带分页查询用户预约记录
     */
    @GetMapping(value = "/record/{page}/{size}")
    public Result getRecordList(@PathVariable("page") int page, @PathVariable("size") int size, @RequestHeader("X-token") String token) {
        IPage<RecordVO> pages = reserveService.getRecordList(page, size, token);
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
