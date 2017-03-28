package com.heleeos.change.spring4_0;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.Test;

import com.heleeos.common.config.TestConfig;

/**
 * Spring 4.0 支持 Java8.
 * 支持Java8的所有特性.
 * 
 * @author liyu
 */
public class TestJDK8 extends TestConfig {

    /**
     * Java8  时间相关的API
     */
    @Test
    public void testTime() {
        Instant instant = Instant.now();
        String dataStr = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                          .withLocale(Locale.CHINA)
                                          .withZone(ZoneId.systemDefault())
                                          .format(instant);
        System.out.println("now is:" + dataStr);
    }
    
    /**
     * Java8 lambda表达式
     */
    @Test
    public void testLambda() {
        new Thread(() -> {
            int i = 0;
            while(i++ <= 100) {
                System.out.println("i:" + i);
            }
        }).start();
        int j = 0;
        while(j ++ <= 100) {
            System.out.println("j:" + j);
        }
    }
}
