package com.heleeos.netty.demo1;

import com.heleeos.netty.demo1.handler.ChannelInitializerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Netty 服务器入口
 * Created by liyu on 01/03/2018.
 */
public class MainApp {

    public static void main(String[] args) {
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
            System.out.println("websocket server start at port:2048");
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group1.shutdownGracefully();
            group2.shutdownGracefully();
        }
    }
}
