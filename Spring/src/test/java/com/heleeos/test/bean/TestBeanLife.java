package com.heleeos.test.bean;

import javax.annotation.Resource;

import org.junit.Test;

import com.heleeos.common.bean.LifecycleBean;
import com.heleeos.common.bean.LifecycleBeanSame;

public class TestBeanLife extends TestBeanConfig {
    
    @Resource(name = "testBean1")
    private LifecycleBean bean1;
    
    @Resource(name = "testBean2")
    private LifecycleBean bean2;
    
    @Resource(name = "testBean3")
    private LifecycleBeanSame bean3;
    
    @Test
    public void test1() {
        System.out.println("bean1:" + bean1);
    }
    
    @Test
    public void test2() {
        System.out.println("bean2:" + bean2);
    }
    
    @Test
    public void test3() {
        System.out.println("bean3:" + bean3);
    }
    
}
