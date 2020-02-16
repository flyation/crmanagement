package com.fly.crmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 预约记录+教室信息 包装类
 */
@Data
@TableName("reserve")
public class RecordClassroom {
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
    private LocalDateTime time; //下单时间
    private String check;       //审核状态(未审核，已通过，已拒绝)

    private String name;        //教室名
    private String building;    //教学楼
    private int floor;          //所在楼层
    private int capacity;       //教室容量
    private String type;        //教室类型
    private int repair;         //是否报修
}
