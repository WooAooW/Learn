package com.heleeos.common.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor - postProcessBeanFactory()");
        System.out.println("beanFactory:" + beanFactory);
        
        //获取Bean的定义信息,然后进行处理,比如 ${jdbc.username} 修改为 具体的值
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String curName : beanNames) {
            BeanDefinition bd = beanFactory.getBeanDefinition(curName);
            System.out.println(bd);
        }
    }
}
