package com.fly.crmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 教室信息
 */
@Data
public class Classroom {
    @TableId(type = IdType.AUTO)
    private Integer id;         //主键
    @TableField("is_deleted")
    private boolean del;        //逻辑删除标志
    private String cid;         //教室编号
    private String name;        //教室名
    private String building;    //教学楼
    private int floor;          //所在楼层
    private int capacity;       //教室容量
    private int type;           //教室类型
    @TableField("is_repaired")
    private int repair;     //是否报修
}
