package com.fly.crmanagement.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * 教室日程VO
 */
@Data
public class ScheduleVO {
    private Integer id;         //主键
    private Integer cid;        //教室id
    private LocalDate date;     //使用日期
    private Boolean course1;    //第1节课
    private Boolean course2;    //第2节课
    private Boolean course3;    //第3节课
    private Boolean course4;    //第4节课
    private Integer number1;    //第1节课人数
    private Integer number2;    //第2节课人数
    private Integer number3;    //第3节课人数
    private Integer number4;    //第4节课人数

    private String name;        //教室名
    private String building;    //教学楼
    private Integer floor;      //教室楼层
    private Integer capacity;   //教室容量
}
