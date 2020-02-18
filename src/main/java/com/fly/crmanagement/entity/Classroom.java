package com.fly.crmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 教室信息
 */
@Data
public class Classroom {
    @TableId(type = IdType.AUTO)
    private Integer id;         //主键
    private String name;        //教室名
    private String building;    //教学楼
    private Integer floor;      //所在楼层
    private Integer capacity;   //教室容量
    private String type;        //教室类型
    private Boolean repair;   //是否报修
}
