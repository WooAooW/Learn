package com.java8;

import java.util.stream.IntStream;

/**
 *
 * Created by liyu on 28/12/2017.
 */
public interface DefaultInterface {


    int read();

    int parseInt(String number);

    default int[] read(int buffer) {
        return IntStream.generate(this::read).limit(buffer).toArray();
    }

    default int parseInt(String number, int defaultNumber) {
        try {
            return parseInt(number);
        } catch (Exception e) {
            return defaultNumber;
        }
    }

}
