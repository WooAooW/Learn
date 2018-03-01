package com.heleeos.netty.demo2;

/**
 * Created by liyu on 01/03/2018.
 */
public class Lanucher {
    public static void main(String[] args) throws Exception {
        // 启动WebSocket
        new WebSocketServer().run(WebSocketServer.WEBSOCKET_PORT);
    }
}
