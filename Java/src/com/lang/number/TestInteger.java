package com.lang.number;

/**
 *
 * Created by liyu on 12/12/2017.
 */
public class TestInteger {

    public static void main(String[] args) {
        Integer n1 = Integer.MIN_VALUE;
        Integer n2 = Integer.MAX_VALUE;

        System.out.println(n1);
        System.out.println(n1 - 1);

        System.out.println(n2);
        System.out.println(n2 + 1);

        System.out.println(n1 > n2);     //false
        System.out.println(n1 - n2 > 0); //true
        System.out.println(n1 - n2);     //1, 溢出

        System.out.println(n2 > n1);     //true
        System.out.println(n2 - n1 > 0); //false
        System.out.println(n2 - n1);     //-1, 溢出
    }
}
