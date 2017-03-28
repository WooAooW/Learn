package com.heleeos.test.bean;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.jndi.support.SimpleJndiBeanFactory;

public class TestBeanFactory {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Test
    public void simpleJndiFactory() {
        BeanFactory factory = new SimpleJndiBeanFactory();
        logger.debug("factory:%s", factory);
    }
}
