package com.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * Created by liyu on 24/11/2017.
 */
public class StreamUtil {


    public static byte[] readFromInput(InputStream inputStream) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];
        int n;
        while((n = inputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, n);
            if(n < 2048) {
                break;
            }
        }
        return baos.toByteArray();
    }

    public static void writeToOutput(OutputStream outputStream, String str) throws IOException {
        writeToOutput(outputStream, str.getBytes());
        outputStream.flush();
    }

    public static void writeToOutput(OutputStream outputStream, byte[] bytes) throws IOException {
        outputStream.write(bytes);
        outputStream.flush();
    }
}
