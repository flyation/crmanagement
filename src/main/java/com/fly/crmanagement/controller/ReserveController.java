package com.fly.crmanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fly.crmanagement.entity.*;
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
     * 带分页查询(有无查询条 ？ 根据条件查询空闲教室 ：查询所有)
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result getPageList(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody ReserveRequest vo) {
        IPage<Schedule> pageData = reserveService.getPageList(page, size, vo);
        return new Result(true, StatusCode.OK, "搜索成功", new PageResult<>(pageData.getTotal(), pageData.getRecords()));
    }

    /**
     * 提交预约申请
     */
    @PostMapping(value = "/apply")
    public Result reserve(@RequestBody ReserveRecord reserve) {
        System.out.println("reserve = " + reserve);
        reserveService.reserve(reserve);
        return new Result(true, StatusCode.OK, "提交成功，请等待审核");
    }
}
