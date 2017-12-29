package com.java8;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 *
 * Created by liyu on 28/12/2017.
 */
public class DateTime {

    public static void main(String[] args) {
        useDate();
        useNew();
        useInstant();
        example1_old();
        example1_new();
    }

    public static void useDate() {
        Date date = new Date(93, 4, 2);
        System.out.println(date); /** Sun May 02 00:00:00 CST 1993 */
    }

    public static void useNew() {
        LocalDate date = LocalDate.of(2008, 5, 2);
        System.out.println(date); /** 2008-05-02 */

        LocalTime time = LocalTime.of(15, 30, 0);
        System.out.println(time); /** 15:30 */

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime); /** 2017-12-28T15:30:06.532 */
    }

    public static void useInstant() {
        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(instant.getNano()); /** 纳秒 */
    }

    public static void example1_old() {
        Date date = new Date();
        int day = date.getDay();
        long time;
        if(day == 6) {
            //星期六
            time = (day - 1) * 24 * 3600_000;
        } else if(day == 0) {
            //星期日
            time = 2 * 24 * 3600_000;
        } else {
            time = (7 - (5 - day)) * 24 * 3600_000;
        }
        Date friday = new Date(date.getTime() - time);
        System.out.println("start:" + friday);
        System.out.println("end:" + date);
    }

    public static void example1_new() {
        LocalDate date = LocalDate.now();
        LocalDate friday = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        System.out.println("start:" + friday);
        System.out.println("end:" + date);
    }
}
