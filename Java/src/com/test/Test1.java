package com.test;

import java.io.File;
import java.nio.file.Files;
import java.util.stream.Stream;

/**
 * Created by liyu on 27/11/2017.
 */
public class Test1 {

    public static void main(String[] args) {
        //changeEncode("人物整形美化处理");
        changeEncode("»ÀœÒ’˚–Œ√¿ªØ¥¶¿Ì");
        Files.copy()
        java.io.BufferedReader
        //changeDirFiles();
    }

    private static void changeDirFiles() {
        File dir = new File("/Users/liyu/Downloads/C篇观摩课程与在线讲解配套文件");
        Stream.of(dir.listFiles())
                .map(Test1::renameFile)
                .forEach(file -> System.out.println(file));
    }

    private static File renameFile(File oldFile) {
        String oldName = oldFile.getName();
        try {
            String newName = changeEncode(oldName);
            return new File(oldFile.getParent(), newName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oldFile;
    }

    private static String changeEncode(String str) {
        int n = str.length();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char thisChar = str.charAt(i);
            if(thisChar > 0) {
                builder.append((char) thisChar);
            } else {
                char nextChar = str.charAt(i + 1);
                builder.append((char) (thisChar << 4 & nextChar));
            }
        }
        return builder.toString();
    }
}
