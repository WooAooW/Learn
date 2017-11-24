package com.lang.thread;

import org.junit.Test;

/**
 *
 * Created by liyu on 24/11/2017.
 */
public class TestThread {

    /**
     * 新建的线程 com.lang.thread 会在 run 方法执行完成后被杀掉
     */
    @Test
    public void run() {
        Thread thread = new Thread(getRunnable());
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " end");
    }

    /**
     * 新建的线程 com.lang.thread 会无限循环
     */
    public static void main(String[] args) {
        Thread thread = new Thread(getRunnable());
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " end");
    }


    private static Runnable getRunnable() {
        return () -> {
            int i = 1;
            while(true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " " + i++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
