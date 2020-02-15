package com.fly.crmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 预约记录
 */
@Data
@TableName("reserve")
public class ReserveRecord {
    @TableId(type = IdType.AUTO)
    private Integer id;         //主键
    private String uid;         //用户id
    private String cid;         //教室id
    private LocalDate date;     //使用日期
    private Boolean course1;        //第1节课
    private Boolean course2;        //第2节课
    private Boolean course3;        //第3节课
    private Boolean course4;        //第4节课
    private String reason;      //申请原因
    private LocalDateTime time; //下单时间
    private String check;       //审核状态(未审核，已通过，已拒绝)
}
