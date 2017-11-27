package com.lang.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

/**
 *
 * Created by liyu on 27/11/2017.
 */
public class Server_2 {

    public static void main(String[] args) {

    }

    public static void startServer() {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(InetSocketAddress.createUnresolved("127.0.0.1", 7070));
            serverSocketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
