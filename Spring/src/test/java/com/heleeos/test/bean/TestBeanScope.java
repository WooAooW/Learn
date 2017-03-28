package com.heleeos.test.bean;

import javax.annotation.Resource;

import org.junit.Test;

import com.heleeos.bean.User;

public class TestBeanScope extends TestBeanConfig {

    @Resource(name = "user1")
    private User u1;
    
    @Resource(name = "user1")
    private User u2;
    
    @Resource(name = "user2")
    private User u3;
    
    @Resource(name = "user2")
    private User u4;
    
    @Test
    public void testScope() {
        System.out.println(String.format("u1 == u2 ? %s", u1 == u2));//true
        System.out.println(String.format("u3 == u4 ? %s", u3 == u4));//false
        System.out.println(String.format("u1:%s", u1));
        System.out.println(String.format("u2:%s", u2));
        System.out.println(String.format("u3:%s", u3));
        System.out.println(String.format("u4:%s", u4));
    }
}
