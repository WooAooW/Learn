package com.heleeos.common.aware;

import org.springframework.beans.factory.BeanClassLoaderAware;

public class MyBeanClassLoaderAware implements BeanClassLoaderAware {

    /**
     * 获取当前的 ClassLoader
     * 调用时机为:    初始化Bean
     * 调用类为:     org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
     * 实际调用对象为: org.springframework.beans.factory.support.DefaultListableBeanFactory
     */
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("MyBeanClassLoaderAware - setBeanClassLoader()");
        System.out.println("ClassLoader:" + classLoader);
        System.out.println("");
    }

}
