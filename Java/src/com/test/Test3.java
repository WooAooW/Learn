package com.test;

/**
 * Created by liyu on 04/12/2017.
 */
public class Test3 {


    static {
        B = 3;
        //A = B;  //还没有初始化, 不能直接使用
    }

    static int A = 1;

    static int B = 2;

    public static void main(String[] args) {
        System.out.println("A:" + A);
        System.out.println("B:" + B);
    }
}
