package com.heleeos.test.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heleeos.common.bean.MyBeanResource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-resource.xml"})
public class TestResource extends AbstractJUnit4SpringContextTests {
    
    private final Logger logger = LogManager.getLogger();
    
    @Autowired
    private MyBeanResource beanResource;
    
    @Test
    public void testDefault() throws Exception {
        ResourceLoader loader = new DefaultResourceLoader();
        Resource resource1 = loader.getResource("file://c:/windows/explorer.exe");
        Resource resource2 = loader.getResource("classpath:application-test.xml");
        Resource resource3 = loader.getResource("https://static.heleeos.com/tool/markdown.css");
        
        logger.info("resource1: {}", resource1);
        logger.info("resource1 - exists: {}", resource1.exists());
        
        logger.info("resource2: {}", resource2);
        logger.info("resource2 - exists: {}", resource2.exists());
        
        logger.info("resource3: {}", resource3);
        logger.info("resource3 - exists: {}", resource3.exists());
    }
    
    @Test
    public void testContextResouce() {
        Resource resource1 = applicationContext.getResource("file://c:/windows/explorer.exe");
        Resource resource2 = applicationContext.getResource("classpath:application-test.xml");
        Resource resource3 = applicationContext.getResource("https://static.heleeos.com/tool/markdown.css");
        
        logger.info("resource1: {}", resource1);
        logger.info("resource1 - exists: {}", resource1.exists());
        
        logger.info("resource2: {}", resource2);
        logger.info("resource2 - exists: {}", resource2.exists());
        
        logger.info("resource3: {}", resource3);
        logger.info("resource3 - exists: {}", resource3.exists());
    }
    
    @Test
    public void testBeanResource() {
        logger.info("BeanResource: {}", beanResource);
        logger.info("BeanResource - Resource: {}", beanResource.getResource());
        logger.info("BeanResource - Html: {}", beanResource.toHtml());
    }
}
