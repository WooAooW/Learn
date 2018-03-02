package com.heleeos.netty.demo1.handler;

import com.heleeos.netty.common.Code;
import com.heleeos.netty.common.Request;
import com.heleeos.netty.common.Response;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import org.apache.log4j.Logger;

/**
 *
 * Created by liyu on 01/03/2018.
 */
public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {

    private Logger logger = Logger.getLogger(getClass());

    private WebSocketServerHandshaker handshaker;

    @Override
    public void messageReceived(ChannelHandlerContext context, Object msg) throws Exception {
        logger.info("接受消息");
        if (msg instanceof FullHttpRequest){
            //HTTP接入，WebSocket第一次连接使用HTTP连接, 用于握手
            handleHttpRequest(context, (FullHttpRequest) msg);
        } else if(msg instanceof WebSocketFrame){
            // WebSocket 接入
            handlerWebSocketFrame(context, (WebSocketFrame) msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext context) throws Exception {
        context.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause) throws Exception {
        logger.error("产生异常，连接被关闭", cause);
        context.close();
    }

    /**
     * HTTP 请求处理
     */
    private void handleHttpRequest(ChannelHandlerContext context, FullHttpRequest request) {
        if (!request.getDecoderResult().isSuccess() || (!"websocket".equals(request.headers().get("Upgrade")))) {
            sendHttpResponse(context, request, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory("ws://localhost:2048/ws", null, false);
        handshaker = wsFactory.newHandshaker(request);
        if (handshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(context.channel());
        } else {
            handshaker.handshake(context.channel(), request);
        }
    }

    private void sendHttpResponse(ChannelHandlerContext context, FullHttpRequest request, DefaultFullHttpResponse response) {
        // 返回应答给客户端
        if (response.getStatus().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(response.getStatus().toString(), CharsetUtil.UTF_8);
            request.content().writeBytes(buf);
            buf.release();
        }
        // 如果是非Keep-Alive，关闭连接
        ChannelFuture future = context.channel().writeAndFlush(request);
        if (!HttpHeaders.isKeepAlive(request) || response.getStatus().code() != 200) {
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }

    /**
     * WebSocket请求
     */
    private void handlerWebSocketFrame(ChannelHandlerContext context, WebSocketFrame frame) {
        logger.info("WebSocket接收到信息");

        //判断是否关闭链路的指令
        if (frame instanceof CloseWebSocketFrame) {
            handshaker.close(context.channel(), (CloseWebSocketFrame) frame.retain());
            return;
        }

        //判断是否ping消息
        if (frame instanceof PingWebSocketFrame) {
            context.channel().write( new PongWebSocketFrame(frame.content().retain()));
            return;
        }

        //本例程仅支持文本消息，不支持二进制消息
        if (frame instanceof BinaryWebSocketFrame) {
            throw new UnsupportedOperationException(String.format("%s frame types not supported", frame.getClass().getName()));
        }
        if(frame instanceof TextWebSocketFrame) {
            // 返回应答消息
            String value = ((TextWebSocketFrame) frame).text();
            logger.info("服务器接收到的信息:" + value);
            Request request = Request.fromJson(value);

            Response response = new Response();
            response.setCode(Code.success);
            response.setMessage("服务端收到信息");
            response.putData("message", request.getMessage());

            context.channel().write(response.getTextWebSocketFrame());
        }
    }
}
