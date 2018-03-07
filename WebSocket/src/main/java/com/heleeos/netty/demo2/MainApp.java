package com.heleeos.netty.demo2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;

/**
 * 多人聊天服务
 * Created by liyu on 01/03/2018.
 */
public class MainApp {

    private static Logger logger = Logger.getLogger(com.heleeos.netty.demo1.MainApp.class);

    public static void main(String[] args) throws Exception {
        logger.info("准备启动 WebSocket");

        EventLoopGroup group1 = new NioEventLoopGroup();
        EventLoopGroup group2 = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(group1, group2)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChatChannelInitializer());
        try {
            Channel channel = serverBootstrap.bind(4096)
                    .sync()
                    .channel();
            logger.info("WebSocket 服务开启");
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            logger.error("启动服务出现错误", e);
        } finally {
            group1.shutdownGracefully();
            group2.shutdownGracefully();
        }
    }
}
