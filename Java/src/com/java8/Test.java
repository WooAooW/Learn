package com.java8;

/**
 * Created by liyu on 29/12/2017.
 */
public class Test {

    public synchronized void sum() {

        Integer a = 1;

        synchronized (a) {
            a = 2;
        }

        System.out.println(a);
    }
}
