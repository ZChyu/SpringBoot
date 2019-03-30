package com.chyuexample.demo.enums;

/**
 * Created by 廖师兄
 * 2017-01-21 14:23
 */
public enum ResultEum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    ERROR_NAME_PASSWORD(100, "用户名或密码错误"),
    ERROR_NULL(101, "用户名或密码不能为空"),
    ERROR_ID(102, "id不能为空"),

    ;

    private Integer code;

    private String msg;

    ResultEum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
