package com.test;

/**
 * Created by liyu on 15/03/2018.
 */
public class Test6 {

    public static void main(String[] args) throws Exception {
        Object obj1 = new Object();

        Class<?> clazz = Class.forName("java.lang.Object");
        Object obj2 = clazz.newInstance();
        Object obj3 = clazz.newInstance();

    }
}
