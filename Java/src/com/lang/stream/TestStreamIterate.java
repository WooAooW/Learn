package com.lang.stream;

import java.util.stream.Stream;

/**
 * Created by liyu on 03/11/2017.
 */
public class TestStreamIterate {

    public static void main(String[] args) {
        Stream.iterate(0, t -> t + 2)
              .map(t -> t * 2)
              .limit(20)
              .forEach(System.out::println);

        Stream.iterate(0, t -> t + 1)
                .mapToInt(t -> t)
                .limit(20)
                .forEach(System.out::println);

//        Stream.iterate()
    }
}
