package com.example.demo.entity;

/**
 * Created by liuchang on 2017/12/26.
 */
public enum Code {
    SUC(0, "请求成功"),
    SYS_ERR(4, "系统错误"),
    ARGS_ERR(12, "参数错误"),
    NON_UPDATE(2000, "不用更新"),
    ;

    Code(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final int code;
    private final String desc;

    public String getCodeStr() {
        return String.valueOf(code);
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
