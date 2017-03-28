package com.heleeos.test.context;


import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.heleeos.common.config.TestConfig;

public class TestApplication extends TestConfig {
    
    private final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    private ApplicationContext autoContext;

    @Test
    public void testNowContext() {
        //GenericApplicationContext
        logger.info(applicationContext);
        logger.info(applicationContext.getApplicationName());
        logger.info(applicationContext.getParentBeanFactory());
        Arrays.asList(applicationContext.getBeanDefinitionNames()).forEach(beanName -> logger.info(beanName));
    }
    
    @Test
    public void testClassPathXML() {
        //ClassPathXmlApplicationContext
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationBeanTest.xml");
        logger.info(context);
        logger.info(context == applicationContext);      //false
        logger.info(context.equals(applicationContext)); //false
        context.close();
    }
    
    @Test
    public void testGeneric() {
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("applicationBeanTest.xml");
        context.refresh();
        logger.info(context);
        logger.info(context.getBean("str1"));
    }
    
    @Test
    public void testClose() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationBeanTest.xml");
        //给JVM注册一个关闭的钩子
        context.registerShutdownHook();
        context.close();
    }
    
    @Test
    public void testAuto() {
        logger.info("测试自动注入...");
        logger.info(autoContext);//GenericApplicationContext
        logger.info(autoContext == applicationContext);//true
    }
}
