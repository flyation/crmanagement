package com.fly.crmanagement.controller;

import com.fly.crmanagement.entity.Repair;
import com.fly.crmanagement.entity.common.Result;
import com.fly.crmanagement.entity.common.StatusCode;
import com.fly.crmanagement.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 保修教室controller
 */
@RestController
@CrossOrigin
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    RepairService repairService;

    @PostMapping("/detail")
    public Result insertRepair(@RequestBody Repair repair) {
        repairService.insertRepair(repair);
        return new Result(true, StatusCode.OK, "提交报修成功");
    }

    @GetMapping("/all")
    public Result findAll() {
        List<Repair> repairList = repairService.findAll();
        return new Result(true, StatusCode.OK, "查询保修记录", repairList);
    }
}
