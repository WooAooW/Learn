package com.heleeos.common.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifecycleBeanSame implements InitializingBean, DisposableBean {

    private String name;

    public LifecycleBeanSame() {
        System.out.println(name + " 构造方法 - LifecycleBeanSame()");
    }
    
    @Override
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println(name + " 接口 - afterPropertiesSet()");
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
    @PreDestroy
    public void destroy() throws Exception {
        System.out.println(name + " 接口 - destroy()");
    }
  
    @Override
    public String toString() {
        return name + " toString()";
    }
}
