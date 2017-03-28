package com.heleeos.common.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import com.heleeos.util.TimeUtil;

public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {

    /**
     * 执行在构造方法,setter方法之后.
     * 执行在Bean的初始化方法之前.
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor - before()");
        System.out.println("Bean:" + bean);
        System.out.println("BeanName:" + beanName);
        System.out.println("BeanClass:" + bean.getClass());
        System.out.println("MyBeanPostProcessor - before() end");
        TimeUtil.sleep(2000);//执行太快了,所以停顿一下
        return bean;//可以做一些依赖之类的处理
    }

    /**
     * 执行在Bean的初始化之后.
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor - after()");
        System.out.println("Bean:" + bean);
        System.out.println("BeanName:" + beanName);
        System.out.println("BeanClass:" + bean.getClass());
        System.out.println("MyBeanPostProcessor - after() end");
        TimeUtil.sleep(2000);//执行太快了,所以停顿一下
        return bean;//返回给后续过程使用的Bean,可以包装或进行其他操作
    }

    /**
     * 数值越大,优先级越低.
     */
    @Override
    public int getOrder() {
        return 0;
    }

}
