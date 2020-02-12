package com.fly.crmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 预约记录
 */
@Data
public class Reservation {
    @TableId(type = IdType.AUTO)
    private Integer id;         //主键
    private String uid;         //用户id
    private String cid;         //教室id
    private Integer capacity;   //教室容量
    private Date date;          //使用日期
    private int course1;        //第1节课
    private int course2;        //第2节课
    private int course3;        //第3节课
    private int course4;        //第4节课
    private Date time;          //订单时间
}
