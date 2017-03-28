package com.heleeos.test.jms;

import java.util.UUID;

import org.apache.activemq.command.ActiveMQMapMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.activemq.command.MessageId;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import com.heleeos.common.config.TestConfig;
import com.heleeos.util.MessageUtil;

public class TestSendMessage extends TestConfig {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private JmsTemplate jmsTemplate;
    
    @Test
    public void sendText() throws Exception {
        ActiveMQTextMessage message = new ActiveMQTextMessage();
        message.setText("测试发送信息");
        jmsTemplate.send("test", (session) -> {return message;});
    }
    
    @Test
    public void sendMap() throws Exception {
        ActiveMQMapMessage message = new ActiveMQMapMessage();
        message.setObject("appid", "kiss-learn-juaofbuw");
        message.setObject("size",  "1980*768");
        jmsTemplate.send("test", (session) -> {return message;});
    }
    
    @Test
    public void testUtil() throws Exception {
        MessageUtil.sendTextMessage(jmsTemplate, "learnSpring", "这是一个正文");
        logger.debug("发送消息...");
    }
    
    @Test
    public void testUtil2() {
        ActiveMQTextMessage message = new ActiveMQTextMessage();
        try {
            message.setMessageId(new MessageId(UUID.randomUUID().toString(), 50));
            message.setText("内容");
        } catch (Exception e) {
            logger.error("[构建消息]异常,原因:" + e.getMessage());
        }
        MessageUtil.sendMessage(jmsTemplate, "learnSpring2", message);
        logger.debug("发送消息2...");
    }
}

@Configuration
class JMSConfig {
    
    @Bean
    public PooledConnectionFactory getFactory() {
        return new PooledConnectionFactory("tcp://192.168.0.204:61616");
    }
    
    @Bean
    public JmsTemplate getJmsTemplate() {
        return new JmsTemplate(getFactory());
    }
}