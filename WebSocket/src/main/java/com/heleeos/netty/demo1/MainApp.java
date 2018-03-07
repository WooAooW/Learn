package com.heleeos.netty.demo1;

import com.heleeos.netty.common.Code;
import com.heleeos.netty.common.Request;
import com.heleeos.netty.common.Response;
import com.heleeos.netty.handler.WebSocketServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.stream.ChunkedWriteHandler;
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
                       .childHandler(new ChildChannel());
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

    static class ChildChannel extends ChannelInitializer<Channel> {
        @Override
        protected void initChannel(Channel channel) throws Exception {
            ChannelPipeline pipeline = channel.pipeline();
            pipeline.addLast("http-codec",new HttpServerCodec());
            pipeline.addLast("aggregator",new HttpObjectAggregator(65536));
            pipeline.addLast("http-chunked",new ChunkedWriteHandler());
            pipeline.addLast("handler", new WebSocketServerHandler((ChannelHandlerContext context, TextWebSocketFrame frame) -> {
                String value = frame.text();
                logger.info("服务器接收到的信息:" + value);
                Request request = Request.fromJson(value);

                Response response = new Response();
                response.setCode(Code.success);
                response.setMessage("服务端收到信息");
                response.putData("message", request.getMessage());

                context.channel().write(response.getTextWebSocketFrame());
            }));
        }
    }
}
