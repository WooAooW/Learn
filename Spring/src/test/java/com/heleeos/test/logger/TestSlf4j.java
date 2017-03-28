package com.heleeos.test.logger;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.heleeos.common.config.TestConfig;

public class TestSlf4j extends TestConfig {

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Test
    public void info() {
        logger.info("logger:{}", logger);
    }
}
