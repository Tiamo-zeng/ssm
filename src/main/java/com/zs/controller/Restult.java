package com.zs.controller;

public class Restult {
    private Object data;
    private Integer code;
    private String msg;

    public Restult() {
    }

    public Restult(Integer code,Object data) {
        this.data = data;
        this.code = code;
    }

    public Restult(Integer code,Object data,String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
