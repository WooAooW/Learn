package com.heleeos.test.logger;

import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;

import com.heleeos.common.config.TestConfig;

public class TestLog4j2 extends TestConfig {

    private final Logger logger = LogManager.getLogger();
   
    @Test
    public void info() {
        logger.info("logger: {}", logger);
    }
}
