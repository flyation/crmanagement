package com.fly.crmanagement.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 教室（用于读取excel的教室实体，和数据库映射的实体做区分）
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomExcel extends BaseRowModel {
    private Integer id;         //主键
    @ExcelProperty(value = "教室名", index = 0)
    private String name;        //教室名
    @ExcelProperty(value = "教学楼", index = 1)
    private String building;    //教学楼
    @ExcelProperty(value = "教室楼层", index = 2)
    private Integer floor;      //教室楼层
    @ExcelProperty(value = "教室容量", index = 3)
    private Integer capacity;   //教室容量
    @ExcelProperty(value = "预约类型", index = 4)
    private Boolean type;        //预约类型
    @ExcelProperty(value = "是否报修", index = 5)
    private Boolean repair;     //是否报修
}
