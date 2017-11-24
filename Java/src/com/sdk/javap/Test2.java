package com.sdk.javap;

/**
 * 包含以下内容
 * 1.算数
 * 2.私有方法
 * 3.三目运算符
 * 4.if判断表达式
 *
 * javap -v -p Test2
 * Created by liyu on 2017/10/10.
 */
public class Test2 {

    public static int add(int a, int b) {
        return a + b;
    }

    private static int getMax(int a, int b) {
        return a > b ? a : b;
    }

    private static int getMin(int a, int b) {
        if(a < b) {
            return a;
        } else {
            return b;
        }
    }
}
