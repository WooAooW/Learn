package com.heleeos.netty.common;

import com.google.gson.Gson;

/**
 * 返回码
 * Created by liyu on 01/03/2018.
 */
public enum  Code {

    success               (200, "成功"),

    login                 (210, "上线请求"),
    send_message          (211, "发送消息"),
    receive_message       (212, "接受消息"),
    logout                (213, "下线请求"),

    clint_removed         (300, "客户端被移除"),

    parameters_incorrect  (400, "参数错误"),
    username_exist        (401, "用户名已经存在"),

    server_error          (500, "执行错误"),
    timeout               (510, "调用超时");

    public Integer code;

    public String info;

    Code(Integer code, String info) {
        this.info = info;
        this.code = code;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
