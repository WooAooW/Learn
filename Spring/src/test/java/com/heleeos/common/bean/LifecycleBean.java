package com.heleeos.common.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifecycleBean implements InitializingBean, DisposableBean {

    private String name;

    public LifecycleBean() {
        System.out.println(name + " 构造方法 - LifecycleBean()");
    }
    
    public LifecycleBean(String name) {
        System.out.println(name + " 有参数的构造方法 - LifecycleBean()");
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name + " 接口 - afterPropertiesSet()");
    }
    
    @PostConstruct
    public void postConstruct() {
        System.out.println(name + " 注解 - postConstruct()");
    }
    
    public void onCreate() {
        System.out.println(name + " 配置 - onCreate()");
    }
    
    public void init() {
        System.out.println(name + " 默认 - init()");
    }
    
    public void setName(String name) {
        this.name = name;
        System.out.println(name + " set - setName()");
    }
    
    public String getName() {
        System.out.println(name + " get - getName()");
        return name;
    }
    
    @Override
    public void destroy() throws Exception {
        System.out.println(name + " 接口 - destroy()");
    }
    
    @PreDestroy
    public void preDestory() {
        System.out.println(name + " 注解 - preDestory()");
    }
    
    public void onDestroy() {
        System.out.println(name + " 配置 - onDestroy()");
    }
    
    public void dispose() {
        System.out.println(name + " 默认 - dispose()");
    }
    
    @Override
    public String toString() {
        return name + " toString()";
    }
}
