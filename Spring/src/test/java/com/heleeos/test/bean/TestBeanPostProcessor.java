package com.heleeos.test.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-bean-post.xml"})
public class TestBeanPostProcessor {

    @Test
    public void test() {
        System.out.println("测试自定义BeanPostProcessor");
    }
}
