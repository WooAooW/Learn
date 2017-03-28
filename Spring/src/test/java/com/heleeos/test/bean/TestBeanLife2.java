package com.heleeos.test.bean;

import javax.annotation.Resource;

import org.junit.Test;

import com.heleeos.common.bean.LifecycleBeanSame;

public class TestBeanLife2 extends TestBeanConfig {
        
    @Resource(name = "testBean3")
    private LifecycleBeanSame bean3;

    @Test
    public void test3() {
        System.out.println("bean3:" + bean3);
    }
    
}
