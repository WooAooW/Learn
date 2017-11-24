package com.lang.net;

import com.common.util.StreamUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;

/**
 * 阻塞服务器的实现
 * Created by liyu on 24/11/2017.
 */
public class Server_1 {

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("启动服务器, 端口号:8080");
            while(true) {
                Socket socket = serverSocket.accept();
                new Thread(getRunnable(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Runnable getRunnable(Socket socket) {
        return () -> {
            try {
                while(true) {
                    InputStream inputStream = socket.getInputStream();
                    byte[] bytes = StreamUtil.readFromInput(inputStream);
                    System.out.println("服务器读取:" + new String(bytes));

                    StreamUtil.writeToOutput(socket.getOutputStream(), Instant.now().toString());
                    System.out.println("服务器写入:当前时间");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
