package com.heleeos.netty.common;

import com.google.gson.Gson;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.HashMap;
import java.util.Map;

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
    private Map<String, String> data = new HashMap<String, String>();

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

    public Map<String, String> getData() {
        return data;
    }

    public void putData(String key, String value) {
        data.put(key, value);
    }

    public TextWebSocketFrame getTextWebSocketFrame() {
        return new TextWebSocketFrame(new Gson().toJson(this));
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
