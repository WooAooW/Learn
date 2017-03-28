package com.heleeos.common.aware;

import org.springframework.beans.factory.BeanNameAware;

public class MyBeanNameAware implements BeanNameAware{

    /**
     * 获取自己的 name
     * 调用时机为:    初始化Bean
     * 调用类为:     org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
     * 实际调用对象为: org.springframework.beans.factory.support.DefaultListableBeanFactory
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("MyBeanNameAware - setBeanName()");
        System.out.println("Name:" + name);
        System.out.println("");
    }

}
