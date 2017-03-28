package com.heleeos.common.bean;

import org.springframework.context.Lifecycle;

/**
 * start 方法不会自动执行.
 * 如果 isRunning 为 true,将会执行 stop()
 */
public class MyLifecycle implements Lifecycle {
    
    private boolean running = false;

    @Override
    public void start() {
        System.out.println("MyLifecycle - start()");
        running = true;
    }

    @Override
    public void stop() {
        System.out.println("MyLifecycle - stop()");
        running = false;
    }

    @Override
    public boolean isRunning() {
        System.out.println("MyLifecycle - isRunning()");
        return running;
    }

}
