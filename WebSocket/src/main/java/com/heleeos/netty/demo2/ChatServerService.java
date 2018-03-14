package com.heleeos.netty.demo2;

import com.heleeos.netty.common.Client;
import com.heleeos.netty.common.Code;
import com.heleeos.netty.common.Response;
import com.heleeos.netty.exception.ChatException;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 聊天服务
 * Created by liyu on 02/03/2018.
 */
public class ChatServerService {

    private static final Logger logger = Logger.getLogger(ChatServerService.class);

    /**
     * 当前连接的客户端
     */
    private static final Map<String, Client> concurrentMap = new ConcurrentHashMap<>();

    /**
     * 用户登录服务器
     */
    public static void login(String requestID, String userName, ChannelHandlerContext context) throws ChatException {
        if(concurrentMap.containsKey(requestID)) {
            throw new ChatException(Code.username_exist);
        }

        Client client = new Client();
        client.setId(requestID);
        client.setName(userName);
        client.setContext(context);

        logger.info(String.format("用户[%s], 登录成功", userName));
        concurrentMap.put(requestID, client);
    }

    /**
     * 获取对应的用户
     * @param requestID 用户请求ID
     */
    public static Client getUser(String requestID) {
        return concurrentMap.get(requestID);
    }

    /**
     * 获取所有用户信息
     * key   -> id
     * value -> name
     */
    public static Map<String, String> getAllUser() {
        return concurrentMap.values().stream().collect(Collectors.toMap(Client::getId, Client::getName));
    }

    /**
     * 用户退出
     * @param userName 用户名
     */
    public static void logout(String userName) {
        logger.info(String.format("用户[%s], 退出成功", userName));
        concurrentMap.remove(userName);
    }

    /**
     * 发送消息
     * @param userName 用户名
     * @param message 要发送的消息
     */
    public void sendToUser(String userName, String message) throws ChatException {
        Client client = concurrentMap.get(userName);
        doSendMessage(client, message);
    }

    /**
     * 给所有人群发消息
     * @param message 要发送的消息
     */
    public void sendToAll(String message) {
        concurrentMap.values().forEach(client -> {
            try {
                doSendMessage(client, message);
            } catch (ChatException e) {
                logger.error(e.getMessage());
            }
        });
    }

    /**
     * 给客户端发送信息
     * @param client 客户端
     * @param message 信息
     */
    private void doSendMessage(Client client, String message) throws ChatException {
        ChannelHandlerContext context = client.getContext();

        if (context == null || context.isRemoved()) {
            throw new ChatException(Code.clint_removed, String.format("客户端[%s]连接失败", client.getName()));
        }

        Response response = new Response(Code.receive_message, message);
        context.channel().write(response.getTextWebSocketFrame());
        context.flush();
    }
}
