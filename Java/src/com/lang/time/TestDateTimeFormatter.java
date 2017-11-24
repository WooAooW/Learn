package com.lang.time;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestDateTimeFormatter {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(ZonedDateTime.now()));
    }
}
