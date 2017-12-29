package com.java8;

import java.util.stream.IntStream;

/**
 *
 * Created by liyu on 29/12/2017.
 */
public class Prime {

    public static void foreach() {
        for(int i = 1; i <= 100; i++) {
            if(isPrime(i)) {
                System.out.print(i + ",");
            }
        }
    }

    public static void stream() {
        IntStream.range(1, 100)
                 .filter(Prime::isPrime)
                 .forEach(System.out::println);
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        foreach();
        stream();
    }
}
