package com.heleeos.netty.demo2;

import com.heleeos.netty.common.Code;
import com.heleeos.netty.common.Request;
import com.heleeos.netty.common.Response;
import com.heleeos.netty.function.MessageHandler;
import com.heleeos.netty.handler.WebSocketServerHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.apache.log4j.Logger;

/**
 *
 * Created by liyu on 07/03/2018.
 */
public class ChatChannelInitializer extends ChannelInitializer<Channel> {

    private Logger logger = Logger.getLogger(getClass());

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast("http-codec",new HttpServerCodec());
        pipeline.addLast("aggregator",new HttpObjectAggregator(65536));
        pipeline.addLast("http-chunked",new ChunkedWriteHandler());
        pipeline.addLast("handler", new WebSocketServerHandler(getMessageHandler()));
    }

    /**
     * 消息处理逻辑
     */
    private MessageHandler getMessageHandler() {
        return (ChannelHandlerContext context, TextWebSocketFrame frame) -> {
            String value = frame.text();
            logger.info("服务器接收到的信息:" + value);
            Request request = Request.fromJson(value);

            String serviceID = request.getServiceID();
            Response response;
            switch (serviceID) {
                case "login":
                    response = login(request);
                    break;
                default:
                    response = error(request);
                    break;
            }
            context.channel().write(response.getTextWebSocketFrame());
        };
    }

    private Response error(Request request) {
        logger.error("不存在的请求服务:" + request);
        return new Response(Code.request_server_error);
    }

    private Response login(Request request) {
        return new Response();
    }
}
