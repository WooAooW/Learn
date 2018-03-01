package com.heleeos.netty.demo2.service;


import com.heleeos.netty.common.Client;
import com.heleeos.netty.common.Request;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import org.apache.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * Created by liyu on 01/03/2018.
 */
public class MessageService {

    private static final Logger logger = Logger.getLogger(MessageService.class);

    private static final Map<String, Client> concurrentMap = new ConcurrentHashMap<String, Client>(); // <requestId, callBack>

    public static boolean register(Request request, ChannelHandlerContext context) {
        String userName = request.getParamValue("userName");

        Client client = new Client();
        client.setName(userName);
        client.setContext(context);

        concurrentMap.put(userName, client);
//        if (Strings.isNullOrEmpty(requestId) || bananaWatchMap.containsKey(requestId)) {
//            return false;
//        }
//        bananaWatchMap.put(requestId, callBack);
//        return true;
        return true;
    }

    public static boolean logout(Request request) {
        String userName = request.getParamValue("userName");

        concurrentMap.remove(userName);
//        if (Strings.isNullOrEmpty(requestId) || !bananaWatchMap.containsKey(requestId)) {
//            return false;
//        }
//        bananaWatchMap.remove(requestId);
        return true;
    }

    public void send(Request request) throws Exception {
        String userName = request.getParamValue("userName");

        Client client = concurrentMap.get(userName);
        ChannelHandlerContext context = client.getContext();


        if (context == null || context.isRemoved()) {
            throw new Exception("尚未握手成功，无法向客户端发送WebSocket消息");
        }
        context.channel().write(new TextWebSocketFrame(request.toJson()));
        context.flush();
    }


    /**
     * 通知所有机器有机器下线
     * @param requestId
     */
    public static void notifyDownline(String requestId) {
//        BananaService.bananaWatchMap.forEach((reqId, callBack) -> { // 通知有人下线
//            Request serviceRequest = new Request();
//            serviceRequest.setServiceId(CODE.downline.code);
//            serviceRequest.setRequestId(requestId);
//            try {
//                callBack.send(serviceRequest);
//            } catch (Exception e) {
//                LOG.warn("回调发送消息给客户端异常", e);
//            }
//        });
    }
}