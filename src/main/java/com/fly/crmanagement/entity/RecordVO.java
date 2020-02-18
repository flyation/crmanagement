package com.fly.crmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 预约记录+教室信息 包装类
 */
@Data
@TableName("reserve")
public class RecordVO {
    @TableId(type = IdType.AUTO)
    private Integer id;         //主键
    private String uid;         //用户id
    private String cid;         //教室id
    private LocalDate date;     //使用日期
    private Boolean course1;    //第1节课
    private Boolean course2;    //第2节课
    private Boolean course3;    //第3节课
    private Boolean course4;    //第4节课
    private String reason;      //申请原因
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime time1; //下单时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime time2; //审核时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime time3; //撤销时间
    private String checked;       //审核状态(待审，通过，否决)
    private Boolean cancel;     //是否撤销


    private String name;        //教室名
    private String building;    //教学楼
    private Integer floor;      //所在楼层
    private Integer capacity;   //教室容量
    private String type;        //教室类型
    private Boolean repair;     //是否报修

    private String username;    //用户名

}
