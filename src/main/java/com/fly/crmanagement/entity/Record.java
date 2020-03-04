package com.fly.crmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 预约记录
 */
@Data
@TableName("reserve")
public class Record {
    @TableId(type = IdType.AUTO)
    private Integer id;         //主键
    private Integer uid;        //用户id
    private Integer cid;        //教室id
    private LocalDate date;     //使用日期
    private Boolean course1;    //第1节课
    private Boolean course2;    //第2节课
    private Boolean course3;    //第3节课
    private Boolean course4;    //第4节课
    private String reason;      //申请原因
    private Boolean cancel;     //是否撤销
    private String checked;     //审核状态(未审核，已通过，已拒绝)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime time1; //下单时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime time2; //审核时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime time3; //撤销时间
    private Boolean type;        //预约类型（true教室，false座位）
}
