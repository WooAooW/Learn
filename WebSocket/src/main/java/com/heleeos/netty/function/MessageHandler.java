package com.heleeos.netty.function;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * 消息处理器
 * Created by liyu on 07/03/2018.
 */
public interface MessageHandler {

    /**
     * 处理文本消息
     * @param context 上下文
     * @param frame 消息
     */
    void handlerTextWebSocketFrame(ChannelHandlerContext context, TextWebSocketFrame frame);
}
