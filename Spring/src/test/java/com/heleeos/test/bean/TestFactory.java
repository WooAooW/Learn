package com.heleeos.test.bean;


import org.junit.Test;

public class TestFactory extends TestBeanConfig {

    @Test
    public void test1() {
        //diyBean:{"id":127,"info":"自定义工厂创建"},工厂:com.helios.bean.MyFactoryBean
        System.out.println(String.format("diyBean:%s,工厂:%s", applicationContext.getBean("diyBean"), applicationContext.getBean("&diyBean")));
    }
}
