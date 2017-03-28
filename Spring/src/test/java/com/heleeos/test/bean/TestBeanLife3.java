package com.heleeos.test.bean;

import javax.annotation.Resource;

import org.junit.Test;

import com.heleeos.common.bean.LifecycleBean;


public class TestBeanLife3 extends TestBeanConfig {
        
    @Resource(name = "testBean4")
    private LifecycleBean bean4;

    @Test
    public void test4() {
        //当构造注入和属性注入都存在时,会先执行构造方法,再执行设值方法
        System.out.println("bean4:" + bean4);
    }
    
}
