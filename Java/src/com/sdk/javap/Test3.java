package com.sdk.javap;

/**
 * 包含以下内容:
 * 1.泛型
 * 2.字符串的优化
 *
 * javap -v Test3
 * Created by liyu on 2017/10/10.
 */
public class Test3 {

    public static <T> T getMax(T t1, T t2) {
        int hash1 = t1.hashCode();
        int hash2 = t2.hashCode();
        if(hash1 > hash2) {
            return t1;
        } else {
            return t2;
        }
    }

    public static void main(String[] args) {
        System.out.println(getMax(5, 2));
        System.out.println(getMax("a" + "b" + "c", "123"));

        int a = new Integer(123);
    }
}
