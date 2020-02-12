package com.fly.crmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 预约条件VO
 */
@Data
public class ReservationVO {
    @TableId(type = IdType.AUTO)
    private Integer id;         //主键
    private Date date;          //使用日期
    private Boolean course1;    //第1节课
    private Boolean course2;    //第2节课
    private Boolean course3;    //第3节课
    private Boolean course4;    //第4节课
    private Integer capacity;   //教室容量
    private String type;       //教室类型
    private String building;   //教学楼
}
