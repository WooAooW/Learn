package com.test;

/**
 *
 * Created by liyu on 02/01/2018.
 */
public class Test4 {

    public static void main(String[] args)
    {
        long start = System.nanoTime();

        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++){

        }
        long finish = System.nanoTime();
        double d = (finish - start) / 1000000.0;

        System.out.println("Time:" + d + "ms");
    }
}
