package com.heleeos.change.spring4_0;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.heleeos.common.config.TestConfig;

/**
 * Spring 4.0 支持lazy注解.
 * 使用@Lazy注解对bean进行延迟加载
 * 
 * @author liyu
 */
public class TestLazy extends TestConfig {
    
    @Test
    public void lazy() {
        System.out.println("lazy");
    }
}

@Lazy
@Configuration
class LazyConfig1 {
    
    @Bean
    public Object LazyLoad1() {
        System.out.println("lazy config1 load object");
        return null;
    }
}

@Configuration
class LazyConfig2 {
    
    @Bean
    public Object LazyLoad2() {
        System.out.println("lazy config22 load object");
        return null;
    }
}

@Lazy
@Configuration
class LazyConfig3 {
    
    @Bean
    public Object LazyLoad3() {
        System.out.println("lazy config333 load object");
        return null;
    }
}