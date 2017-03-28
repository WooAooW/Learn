package com.heleeos.common.bean;

import com.google.gson.Gson;

public class DiyBean {
    
    private int id;
    
    private String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
