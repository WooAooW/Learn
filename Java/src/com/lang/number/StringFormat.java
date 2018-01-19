package com.lang.number;

/**
 * 字符串格式化
 * Created by liyu on 19/01/2018.
 */
public class StringFormat {

    public static void main(String[] args) {
        System.out.println(String.format("%2s, %4s, %5s, %5s, %5s, %5s", "N", "B", "0001", "0010", "0100", "1000"));
        for(int i = 0; i <= 15; i++) {
            System.out.println(String.format("%02d, %04d, %5s, %5s, %5s, %5s",
                    i,
                    Integer.parseInt(Integer.toBinaryString(i)),
                    (i & 1) == 1,
                    (i & 2) == 2,
                    (i & 4) == 4,
                    (i & 8) == 8
            ));
        }
    }
}
