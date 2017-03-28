package com.heleeos.change.spring4_0;

import org.junit.Test;
import org.springframework.util.SocketUtils;

/**
 * Spring 4.0 新增工具类.
 * SocketUtils可以获取随机可用端口.
 * 
 * @author liyu
 */
public class TestSocketUtils {

    @Test
    public void test() {
        //寻找一个可用的tcp端口
        System.out.println(SocketUtils.findAvailableTcpPort());
        
        //寻找一个可用的tcp端口,最小端口为8080
        System.out.println(SocketUtils.findAvailableTcpPort(8080));
        
        //寻找一个可用的tcp端口,范围为1 ~ 300
        System.out.println(SocketUtils.findAvailableTcpPort(1, 300));
        
        //寻找10个可用的tcp端口
        System.out.println(SocketUtils.findAvailableTcpPorts(10));
        
        //寻找10个可用的tcp端口,且范围为 2020 ~ 3030
        System.out.println(SocketUtils.findAvailableTcpPorts(10, 2020, 3030));
    }
}
