package com.fly.crmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

/**
 * 报修信息（数据库映射实体）
 */
@Data
public class Repair {
    @TableId(type = IdType.AUTO)
    private Integer id;               // 主键
    private Integer cid;              // 教室id
    private String name;              // 教室名
    private String building;          // 教学楼
    private String detail;            // 报修详情
    private LocalDate date;           // 报修时间

}
