package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * Created by liyu on 29/12/2017.
 */
public class Prime3 {

    private static void foreach() {
        int count = 1;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 10000; i++) {
            if(Prime.isPrime(i)) {
                list.add(i);
                if(count++ >= 40) {
                    break;
                }
            }
        }
        //list doSomething
    }

    private static void stream() {
        int numbers[] = IntStream.range(1, 100)
                                 .filter(Prime::isPrime)
                                 .limit(40)
                                 .toArray();
        //numbers doSomething
    }

    public static void main(String[] args) {
        foreach();
        stream();
    }
}
