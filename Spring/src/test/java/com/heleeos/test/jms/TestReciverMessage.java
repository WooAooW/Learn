package com.heleeos.test.jms;


import java.util.Map;

import javax.jms.Message;

import org.apache.activemq.command.ActiveMQMapMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

import com.google.gson.Gson;
import com.heleeos.common.config.TestConfig;

/**
 * JMS接受消息相关的内容.
 */
public class TestReciverMessage extends TestConfig {
    
    /**
     * JMS连接.
     */
    @Autowired
    private JmsTemplate jmsTemplate;
    
    /**
     * 接收信息.
     */
    @Test
    public void testReciver() throws Exception {
        System.out.println("测试接受信息");
        Message message = jmsTemplate.receive("test");
        String text = message.toString();
        if(message instanceof ActiveMQTextMessage) {
            text = ((ActiveMQTextMessage) message).getText();
        } else if(message instanceof ActiveMQMapMessage) {
            Map<String, Object> map = ((ActiveMQMapMessage) message).getContentMap();
            text = new Gson().toJson(map);
        }
        System.out.println(text);
    }
}

@Configurable
class ReciverConfig {
    
    @Bean
    public PooledConnectionFactory getFactory() {
        return new PooledConnectionFactory("tcp://192.168.0.204:61616");
    }
    
    @Bean
    public JmsTemplate getJmsTemplate() {
        return new JmsTemplate(getFactory());
    }
}
