package com.heleeos.change.spring4_0;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.heleeos.common.config.TestConfig;

/**
 * Spring 4.0 新增order注解.
 * 可以使用@Order注解对bean加载进行排序.
 * 
 * @author liyu
 */
public class TestOrder extends TestConfig {
    
    @Test
    public void order() {
        System.out.println("order");
    }
}

@Order(2)
@Configuration
class OrderConfig1 {
    
    @Bean
    public Object OrderLoad1() {
        System.out.println("order config1 load object");
        return null;
    }
}

@Order(3)
@Configuration
class OrderConfig2 {
    
    @Bean
    public Object OrderLoad2() {
        System.out.println("order config22 load object");
        return null;
    }
}

@Order(1)
@Configuration
class OrderConfig3 {
    
    @Bean
    public Object OrderLoad3() {
        System.out.println("order config333 load object");
        return null;
    }
}