package com.fly.crmanagement.entity;

import lombok.Data;

import java.util.List;

/**
 * 分页结果类
 * @param <T>
 */
@Data
public class PageResult<T> {
    private Long total;    //返回码
    private List<T> rows;  //返回信息

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
