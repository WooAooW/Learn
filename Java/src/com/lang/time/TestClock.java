package com.lang.time;

import java.time.Clock;
import java.time.Duration;
import java.time.ZoneId;

public class TestClock {

    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock + " " + clock.instant().atZone(ZoneId.systemDefault()));
        
        Clock clock2 = Clock.offset(Clock.systemDefaultZone(), Duration.ofDays(1));
        System.out.println(clock2 + " " + clock2.instant().atZone(ZoneId.systemDefault()));
    }
}
