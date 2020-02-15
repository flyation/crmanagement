package com.fly.crmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

/**
 * 教室日程VO
 */
@Data
public class ScheduleVO {
    @TableId(type = IdType.AUTO)
    private Integer id;         //主键
    private Integer cid;        //教室id
    private String name;        //教室名
    private String building;    //教学楼
    private Integer floor;      //教室楼层
    private Integer capacity;   //教室容量
    private String type;        //教室类型
    private LocalDate date;     //使用日期
    private Boolean course1;    //第1节课
    private Boolean course2;    //第2节课
    private Boolean course3;    //第3节课
    private Boolean course4;    //第4节课
}
