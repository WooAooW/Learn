package com.heleeos.netty.common;

/**
 * 服务端返回的结果
 * Created by liyu on 01/03/2018.
 */
public class Response {

    /** 返回结果码 */
    private Code code;

    /** 返回信息 */
    private String message;

    /** 返回数据 */
    private Object data;

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
