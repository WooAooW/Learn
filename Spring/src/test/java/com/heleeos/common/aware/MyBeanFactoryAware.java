package com.heleeos.common.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class MyBeanFactoryAware implements BeanFactoryAware {

    /**
     * 获取当前的 BeanFactory
     * 调用时机为:    初始化Bean
     * 调用类为:     org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
     * 实际调用对象为: org.springframework.beans.factory.support.DefaultListableBeanFactory
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryAware - setBeanFactory()");
        System.out.println("BeanFactory:" + beanFactory);
        System.out.println("");
    }

}
