package com.lang.net;

import com.common.util.StreamUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Socket 客户端的实现
 * Created by liyu on 24/11/2017.
 */
public class Client_1 {

    public static void main(String[] args) {
        startClient();
    }

    private static void startClient() {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);

            new Thread(getRunnable(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Runnable getRunnable(Socket socket) {
        return () -> {
            try {
                while(true) {
                    System.out.println("客户端发送:获取时间");
                    StreamUtil.writeToOutput(socket.getOutputStream(), "获取时间".getBytes());

                    InputStream inputStream = socket.getInputStream();
                    byte[] bytes = StreamUtil.readFromInput(inputStream);
                    System.out.println("客户端获取:" + new String(bytes));

                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
