package com.heleeos.test.annotation;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestAutowired extends TestAnnotationConfig {

    @Test
    public void testBeanPostProcessor() {
        Map<String, BeanPostProcessor> processors = applicationContext.getBeansOfType(BeanPostProcessor.class);
        processors.forEach((key, value) -> System.out.println(String.format("key:%s,value:%s", key, value)));
    }
}
