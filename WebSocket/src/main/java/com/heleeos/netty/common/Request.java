package com.heleeos.netty.common;

import com.google.gson.Gson;

import java.util.Map;

/**
 * 每次客户端的请求
 * Created by liyu on 01/03/2018.
 */
public class Request {

    /** 请求ID */
    private String requestID;

    /** 服务ID */
    private String serviceID;

    /** 请求的消息 */
    private String message;

    /** 请求的参数 */
    private Map<String, String> params;

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public String getParamValue(String key) {
        return params.get(key);
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public static Request fromJson(String text) {
        return new Gson().fromJson(text, Request.class);
    }

    @Override
    public String toString() {
        return toJson();
    }
}
