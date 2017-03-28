package com.heleeos.util;

import javax.jms.Message;
import javax.jms.MessageNotWriteableException;

import org.apache.activemq.command.ActiveMQMapMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.util.Assert;

import com.google.gson.Gson;

/**
 * JMS相关的工具. 
 * 
 * @author liyu
 */
public final class MessageUtil {
    
    /**
     * 发送文本信息.
     * <br/>
     * 例如: sendMessage(myJms, "test-web", "testMessage")
     * 
     * @param jmsTemplate 发送信息的连接
     * @param destination 要发送信息的目的地
     * @param text        要发送的文本信息
     * 
     * @throws MessageNotWriteableException 文本信息不可写
     * @throws IllegalAccessException JmsTemplate, destination, message 为 null, 或者 destination 为空字符串
     */
    public static void sendTextMessage(final JmsTemplate jmsTemplate, final String destination, final String text) throws MessageNotWriteableException {
        ActiveMQTextMessage message = new ActiveMQTextMessage();
        message.setText(text);
        sendMessage(jmsTemplate, destination, message);
    }
    
    /**
     * 发送信息.
     * <br/>
     * 例如: sendMessage(myJms, "test-web", myMessage)
     * 
     * @param jmsTemplate 发送信息的连接
     * @param destination 要发送信息的目的地
     * @param message     要发送的信息对象
     * 
     * @throws IllegalAccessException JmsTemplate, destination, message 为 null, 或者 destination 为空字符串
     */
    public static void sendMessage(final JmsTemplate jmsTemplate, final String destination, final Message message) {
        Assert.notNull(jmsTemplate, "JmsTemplate 不能为null");
        Assert.notNull(destination, "destination 不能为null");
        Assert.notNull(message,     "message 不能为null");
        if(destination.isEmpty()){
            throw new IllegalArgumentException("destination 不能为空字符串");
        }
        jmsTemplate.send(destination, session -> message);
    }
    
    /**
     * 接收一个文本信息.
     * 
     * @param jmsTemplate 发送信息的连接
     * @param destination 要发送信息的目的地
     * 
     * @throws IllegalAccessException JmsTemplate, destination 为 null 或者 destination 为空字符串
     */
    public static String reciverString(final JmsTemplate jmsTemplate, final String destination) throws Exception {
        return new Gson().toJson(reciverObject(jmsTemplate, destination));
    }
    
    /**
     * 接收一个对象,可能为 map 或 string 或者 message.
     * 
     * @param jmsTemplate 发送信息的连接
     * @param destination 要发送信息的目的地
     * 
     * @throws IllegalAccessException JmsTemplate, destination 为 null 或者 destination 为空字符串
     */
    public static Object reciverObject(final JmsTemplate jmsTemplate, final String destination) throws Exception {
        Message message = reciverMessage(jmsTemplate, destination);
        if(message instanceof ActiveMQTextMessage) {
            return ((ActiveMQTextMessage) message).getText();
        } else if(message instanceof ActiveMQMapMessage) {
            return ((ActiveMQMapMessage) message).getContentMap();
        } else {
            return message;
        }
    }
    
    /**
     * 接收信息.
     * 如果当前的消息中间件中没有信息时,该方法将会阻塞.
     * <br/>
     * 例如: reciverMessage(myJms, "test-web")
     * 
     * @param jmsTemplate 发送信息的连接
     * @param destination 要发送信息的目的地
     * 
     * @throws IllegalAccessException JmsTemplate, destination 为 null 或者 destination 为空字符串
     */
    public static Message reciverMessage(final JmsTemplate jmsTemplate, final String destination) {
        Assert.notNull(jmsTemplate, "JmsTemplate 不能为null");
        Assert.notNull(destination, "destination 不能为null");
        return jmsTemplate.receive(destination);
    }
}
