package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * Created by liyu on 29/12/2017.
 */
public class Prime2 {

    private static void foreach() {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            if(Prime.isPrime(i)) {
                list.add(i);
            }
        }
        //list doSomething
    }

    private static void stream() {
        int numbers[] = IntStream.range(1, 100)
                                 .filter(Prime::isPrime)
                                 .toArray();
        //numbers doSomething
    }

    public static void main(String[] args) {
        foreach();
        stream();
    }
}
