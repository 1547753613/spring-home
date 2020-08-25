package com.aaa.springboothomestay.entity;

import lombok.Data;

@Data
public class ResResult {
    private Boolean success = true;
    private String msg;

    public ResResult(){}
    public ResResult(Boolean success,String msg) {
        this.success = success;
        this.msg = msg;
    }
}
