package com.fly.crmanagement.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 预约条件VO 查询条件
 */
@Data

public class ReserveVO {
    private LocalDate date;     //使用日期
    private Boolean course1;    //第1节课
    private Boolean course2;    //第2节课
    private Boolean course3;    //第3节课
    private Boolean course4;    //第4节课

    private Integer capacity;   //教室容量
    private String type;        //教室类型
    private String building;    //教学楼
}
