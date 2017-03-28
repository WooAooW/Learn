package com.heleeos.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.function.Consumer;

public final class TimeUtil {

    public static String getNow() {
        return getTimeString("yyyy-MM-dd hh:mm:ss");
    }
    
    public static String getTody() {
        return getTimeString("yyyy-MM-dd");
    }
    
    public static String getTimeString(String pattern) {
        return DateTimeFormatter.ofPattern(pattern, Locale.CHINA)
                                .withZone(ZoneId.systemDefault())
                                .format(Instant.now());
    }
    
    public static void sleep(long millis) {
        sleep(millis, null);
    }
    
    public static void sleep(long millis, Consumer<Exception> callBack) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            if(callBack != null) callBack.accept(e);
        }
    }
}
