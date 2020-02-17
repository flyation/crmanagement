package com.fly.crmanagement.entity.common;

import lombok.Data;

/**
 * 通用结果类
 */
@Data
public class Result {
    private boolean flag;    //是否成功
    private Integer code;    //返回码
    private String message;  //返回信息
    private Object data;     //返回数据

    public Result() {
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
