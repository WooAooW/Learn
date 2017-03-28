package com.heleeos.test.utils;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * StringUtil 相关的内容.
 */
public class TestStringUtils {

    /**
     * 替换字符串.
     * 
     * 第一个参数为旧的字符串
     * 第二个参数为要替换的字符串
     * 第三个参数为要替换成的字符串
     */
    @Test
    public void replace() {
        String str = "xz bas pdqpw mpvna owij oikzsc najsd aksd hjvbaksb das dhqjwe pos kasdas dabc aba dbcabdc";
        System.out.println(StringUtils.replace(str, " ", " ~ "));
    }
    
    /**
     * 字符串分割为数组.
     * 
     * 第一个参数为字符串
     * 第二个参数为分隔符
     * 第三个参数为分割后要删除的内容
     */
    @Test
    public void delimited() {
        String str = "/home/server/apps/myApp/WEB-INF/classes/../../img";
        dispArray(StringUtils.delimitedListToStringArray(str, "/", "."));
        dispArray(StringUtils.delimitedListToStringArray(str, "kiss", "."));
    }
    
    /**
     * 规范化路径.
     * 
     * 如果存在相对路径,则进行自动计算.
     */
    @Test
    public void cleanPath() {
        String path1 = "file:C:/Windows/System32/drivers/etc/hosts";
        String path2 = "/home/server/apps/myApp/WEB-INF/classes/../../img";
        String path3 = "file:";
        System.out.println(StringUtils.cleanPath(path1));
        System.out.println(StringUtils.cleanPath(path2));
        System.out.println(StringUtils.cleanPath(path3));
    }
    
    /**
     * 循环显示数组.
     */
    @SuppressWarnings("unchecked")
    private <T> void dispArray(T...t){
        Arrays.asList(t).forEach((obj) -> System.out.println(obj));
    }
}
