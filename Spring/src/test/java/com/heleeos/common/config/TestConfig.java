package com.heleeos.common.config;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-test.xml"})
public class TestConfig extends AbstractJUnit4SpringContextTests {
    //一个空的Application
    
    //公共测试代码的配置信息
}