package com.heleeos.test.bean;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heleeos.common.bean.MyDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-bean-datasource.xml"})
public class TestMyDataSource {

    @Resource(name = "dataSource1")
    private MyDataSource dataSource1;
    
    @Resource(name = "dataSource2")
    private MyDataSource dataSource2;
    
    @Test
    public void test() {
        System.out.println("dataSource1:" + dataSource1);
        System.out.println("dataSource2:" + dataSource2);
    }
}
