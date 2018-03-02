package com.heleeos.netty.demo1;

import com.heleeos.netty.handler.ChannelInitializerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;

/**
 * Netty 服务器入口
 *
 * 一个简单的收发消息的服务器
 * Created by liyu on 01/03/2018.
 */
public class MainApp {

    private static Logger logger = Logger.getLogger(MainApp.class);

    public static void main(String[] args) {
        logger.info("准备启动 WebSocket");

        EventLoopGroup group1 = new NioEventLoopGroup();
        EventLoopGroup group2 = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(group1, group2)
                       .channel(NioServerSocketChannel.class)
                       .childHandler(ChannelInitializerHandler.INSTANCE);
        try {
            Channel channel = serverBootstrap.bind(2048)
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
