package com.java8;

import java.util.stream.IntStream;

/**
 *
 * Created by liyu on 28/12/2017.
 */
public interface DefaultInterface {


    int read();

    int parseInt(String number);

    default int sum() {
        return 0;
    }

}
