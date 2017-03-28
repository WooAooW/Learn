package com.heleeos.common.bean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<DiyBean> {

    @Override
    public DiyBean getObject() throws Exception {
        DiyBean bean = new DiyBean();
        bean.setId((int)(Math.random() * 200));
        bean.setInfo("自定义工厂创建");
        return bean;
    }

    @Override
    public Class<?> getObjectType() {
        return DiyBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
