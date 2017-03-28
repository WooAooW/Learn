package com.heleeos.common.aware;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class MyApplicationEventPublisherAware implements ApplicationEventPublisherAware {

    /**
     * 获取当前的 Application
     * 调用时机为: 工厂创建bean之前
     * 调用方为:  org.springframework.context.support.ApplicationContextAwareProcessor
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("MyApplicationEventPublisherAware - setApplicationEventPublisher()");
        System.out.println("ApplicationEventPublisher" + applicationEventPublisher);
        System.out.println("");
    }

}
