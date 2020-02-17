package com.fly.crmanagement.entity.common;

/**
 * 状态码
 */
public class StatusCode {
    public static final int OK = 20000;             //成功
    public static final int ERROR = 20001;          //失败
    public static final int LOGINERROR = 20002;     //账号或密码错误
    public static final int ACCESSERROR = 20003;    //权限不足
    public static final int REMOTEERROR = 20004;    //远程调用失败
    public static final int REPEROR = 20005;        //重读操作
}
