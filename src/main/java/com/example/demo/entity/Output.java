package com.example.demo.entity;

/**
 * Created by liuchang on 2017/12/26.
 */
public class Output<T> {
    private String code;
    private String message;
    private T data;

    public Output(Code code) {
        setCode(code.getCode());
        setMessage(code.getDesc());
    }

    public Output() {
        code = "0";
        this.data = null;
    }

    public Output(T data) {
        code = "0";
        this.data = data;
    }

    public Output(Throwable e) {
        this.code = Code.SYS_ERR.getCodeStr();
        this.message = Code.SYS_ERR.getDesc();
        this.data = null;


    }

    public String getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = String.valueOf(code);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }
}
