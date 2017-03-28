package com.heleeos.common.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyApplicationContextAware implements ApplicationContextAware {

    /**
     * 获取当前的 Application
     * 调用时机为: 工厂创建bean之前
     * 调用方为:  org.springframework.context.support.ApplicationContextAwareProcessor
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("MyApplicationContextAware - setApplicationContext()");
        System.out.println("ApplicationContext:" + applicationContext);
        System.out.println("");
    }
}
