package com.fly.crmanagement.controller;

import com.fly.crmanagement.entity.Record;
import com.fly.crmanagement.entity.ScheduleVO;
import com.fly.crmanagement.entity.common.Result;
import com.fly.crmanagement.entity.common.StatusCode;
import com.fly.crmanagement.service.QRService;
import com.fly.crmanagement.util.FlyUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 二维码登录、预约模块
 */
@RestController
@CrossOrigin
@RequestMapping("/qr")
public class QRController {

    @Resource
    QRService qrService;

    /**
     * 用户扫描身份二维码，系统记住用户信息，并发放身份码（四位随机数字）
     * @param
     * @return
     */
    @GetMapping("/login/{uid}")
    public Result login(@PathVariable("uid") int uid, HttpServletRequest req) {
        System.out.println("二维码登入，用户id：" + uid);
        // 发放身份码（四位随机数字）
        String code = FlyUtil.randomIDCodeOf4();
        System.out.println("本次身份码：" + code);
        // 保存用户id——本次身份码
        req.getSession().setAttribute(uid + "Code", code);
        return new Result(true, StatusCode.OK, "二维码验证成功");
    }


    @PostMapping("/roomSchedule")
    public Result getRoomSchedule(@RequestBody ScheduleVO vo) {
        ScheduleVO scheduleVO = qrService.getRoomSchedule(vo);
        return new Result(true, StatusCode.OK, "roomSchedule", scheduleVO);
    }

    // 二维码快速预约教室
    @PostMapping("/reserve")
    public Result reserve(@RequestBody Record record) {
        qrService.reserve(record, 2);
        return new Result(true, StatusCode.OK, "预约成功，请等待审核");
    }

    @PostMapping("/test")
    public Result test(@RequestBody Record record) {
        System.out.println("test...");
        return new Result(true, StatusCode.OK, "test...");
    }
}
