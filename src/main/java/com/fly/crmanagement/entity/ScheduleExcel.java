package com.fly.crmanagement.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 日程（用于读取excel的日程实体，和数据库映射的实体做区分）
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleExcel extends BaseRowModel {
    @ExcelProperty(value = "教室id", index = 0)
    private Integer cid;        // 教室id
    @ExcelProperty(value = "日期", index = 1)
    private String date;        // 日期
    @ExcelProperty(value = "第一节课", index = 2)
    private String course1;    // 第一节课
    @ExcelProperty(value = "第二节课", index = 3)
    private String course2;    // 第二节课
    @ExcelProperty(value = "第三节课", index = 4)
    private String course3;    // 第三节课
    @ExcelProperty(value = "第四节课", index = 5)
    private String course4;    // 第四节课

}
