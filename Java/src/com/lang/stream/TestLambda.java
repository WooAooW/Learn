package com.lang.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 *  计算 (1 + 2) * 3 - 4
 *
 *  int a = 1 + 2
 *  int b = a * 3
 *  int c = b - 4
 *
 *  add(1, 2).multiply(3).subtract(4)
 *
 *
 * Created by liyu on 28/12/2017.
 */
public class TestLambda {


    /**
     *
     *  计算 (1 + 2) * 3 - 4
     *
     *  int a = 1 + 2
     *  int b = a * 3
     *  int c = b - 4
     *
     *  add(1, 2).multiply(3).subtract(4)
     *
     */

    public static void Imperative(int data[]) {
        int sum = 0;
        for(int i = 0; i < data.length; i++) {
            if(data[i] % 2 == 0) {
                sum = sum + data[i];
            }
        }
        System.out.println("Sum:" + sum);
    }

    public static void Functional(int data[]) {
        int sum = Arrays.stream(data).parallel()
                        .filter(num -> num % 2 == 0)
                        .sum();
        System.out.println("Sum:" + sum);
    }

    public static void main(String[] args) {
        int data[] = IntStream.range(0, 99999999).toArray();
        Imperative(data);
        Functional(data);
    }
}
