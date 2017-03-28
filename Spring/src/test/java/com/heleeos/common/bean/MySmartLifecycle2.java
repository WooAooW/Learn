package com.heleeos.common.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.SmartLifecycle;

/**
 * isAutoStartup 为true,isRunning 为false, 将会执行 start()
 * 如果 isRunning 为 true,将会执行 stop()
 */
public class MySmartLifecycle2 implements SmartLifecycle, InitializingBean, DisposableBean {
    
    private boolean running = false;
    
    private String name;

    public MySmartLifecycle2() {
        System.out.println("MySmartLifecycle2 - 无参构造方法");
    }
    
    public MySmartLifecycle2(String name) {
        System.out.println("MySmartLifecycle2 - 有参构造方法");
        this.name = name;
    }
    
    public void setName(String name) {
        System.out.println("MySmartLifecycle2 - setName()");
        this.name = name;
    }
    
    public String getName() {
        System.out.println("MySmartLifecycle2 - getName()");
        return name;
    }
    
    @Override
    public void start() {
        System.out.println("MySmartLifecycle2 - start() - Lifecycle");
        running = true;
    }

    @Override
    public void stop() {
        System.out.println("MySmartLifecycle2 - stop() - Lifecycle");
        running = false;
    }

    @Override
    public boolean isRunning() {
        System.out.println("MySmartLifecycle2 - isRunning() - Lifecycle");
        return running;
    }

    @Override
    public int getPhase() {
        System.out.println("MySmartLifecycle2 - getPhase() - Lifecycle");
        return 0;
    }

    /**
     * 如果返回false,将不会自动执行.
     */
    @Override
    public boolean isAutoStartup() {
        System.out.println("MySmartLifecycle2 - isAutoStartup() - Lifecycle");
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        System.out.println("MySmartLifecycle2 - stop() - Lifecycle");
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MySmartLifecycle2 - afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MySmartLifecycle2 - destroy()");
    }
    
    public void onCreate() {
        System.out.println("MySmartLifecycle2 - onCreate() - 配置的init");
    }
    
    public void onDestroy() {
        System.out.println("MySmartLifecycle2 - onDestroy() - 配置的destroy");
    }    
    
    @PostConstruct
    public void postConstruct() {
        System.out.println("MySmartLifecycle2 - postConstruct() - 注解初始化");
    }
    
    @PreDestroy
    public void preDestroy() {
        System.out.println("MySmartLifecycle2 - PreDestroy() - 注解销毁");
    }
}
