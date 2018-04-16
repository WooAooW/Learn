package com.heleeos.jar;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 读取配置文件
 * Created by liyu on 2018/4/16.
 */
public class ReadConfig {

    public static void main(String[] args) {
        File file = new File("config.ini");
        Properties properties = readConfig(file);
        if(properties != null) {
            String userName = properties.getProperty("UserName", "root");
            String passWord = properties.getProperty("PassWord", "admin");
            System.out.println(userName + "," + passWord);
        }
    }

    /**
     * 根据指定的文件读取配置信息
     * @param file 文件
     */
    private static Properties readConfig(File file) {
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
