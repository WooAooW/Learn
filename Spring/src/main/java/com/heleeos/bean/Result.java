package com.heleeos.bean;

import java.io.Serializable;

import com.google.gson.Gson;

public class Result implements Serializable {

    private static final long serialVersionUID = -2980505621027255472L;
    
    private int code;
    
    private Object message;

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public Object getMessage() {
        return message;
    }

    public Result setMessage(Object message) {
        this.message = message;
        return this;
    }
    
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
