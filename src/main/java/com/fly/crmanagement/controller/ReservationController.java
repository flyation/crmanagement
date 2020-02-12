package com.fly.crmanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fly.crmanagement.dao.ScheduleMapper;
import com.fly.crmanagement.entity.*;
import com.fly.crmanagement.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 预约教室controller
 */
@RestController
@CrossOrigin
@RequestMapping("/reservation")
public class ReservationController {

    @Resource
    private ReservationService reservationService;

    /**
     * 带分页查询(有无查询条 ？ 根据条件查询空闲教室 ：查询所有)
     * @param page
     * @param size
     * @param vo
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result getPageList(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody ReservationVO vo) {
        System.out.println("controller...");
        IPage<Schedule> pageData = reservationService.getPageList(page, size, vo);
        return new Result(true, StatusCode.OK, "搜索成功", new PageResult<>(pageData.getTotal(), pageData.getRecords()));
    }
}
