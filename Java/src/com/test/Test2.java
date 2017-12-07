package com.test;

/**
 * Created by liyu on 04/12/2017.
 */
public class Test2 {

    static class Class1 {
        static int number1 = 10;

        static {
            number1 = 20;
        }
    }

    static class Class2 extends Class1 {
        static {
            number1 = 40;
        }

        static int number1 = 30;
    }

    public static void main(String[] args) {
        System.out.println(Class1.number1); //20
        System.out.println(Class2.number1); //30
    }
}
