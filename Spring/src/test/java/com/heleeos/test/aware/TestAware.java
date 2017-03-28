package com.heleeos.test.aware;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-aware.xml"})
public class TestAware {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test() {
        logger.info("测试Aware");
    }
}
