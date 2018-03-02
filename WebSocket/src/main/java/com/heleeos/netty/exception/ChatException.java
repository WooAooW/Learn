package com.heleeos.netty.exception;

import com.heleeos.netty.common.Code;

/**
 *
 * Created by liyu on 02/03/2018.
 */
public class ChatException extends Exception {

    private Code code;

    private String message;

    public ChatException(Code code) {
        this.code = code;
        this.message = code.info;
    }

    public ChatException(Code code, String message) {
        this.code = code;
        this.message = message;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
