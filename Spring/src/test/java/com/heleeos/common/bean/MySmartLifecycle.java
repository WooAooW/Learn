package com.heleeos.common.bean;

import org.springframework.context.SmartLifecycle;

/**
 * isAutoStartup 为true,isRunning 为false, 将会执行 start()
 * 如果 isRunning 为 true,将会执行 stop()
 */
public class MySmartLifecycle implements SmartLifecycle {
    
    private boolean running = false;

    @Override
    public void start() {
        System.out.println("MySmartLifecycle - start()");
        running = true;
    }

    @Override
    public void stop() {
        System.out.println("MySmartLifecycle - stop()");
        running = false;
    }

    @Override
    public boolean isRunning() {
        System.out.println("MySmartLifecycle - isRunning()");
        return running;
    }

    @Override
    public int getPhase() {
        System.out.println("MySmartLifecycle - getPhase()");
        return 0;
    }

    /**
     * 如果返回false,将不会自动执行.
     */
    @Override
    public boolean isAutoStartup() {
        System.out.println("MySmartLifecycle - isAutoStartup()");
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        System.out.println("MySmartLifecycle - stop()");
    }
}
