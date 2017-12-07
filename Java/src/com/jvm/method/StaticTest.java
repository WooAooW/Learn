package com.jvm.method;

import com.common.bean.Man;
import com.common.bean.People;
import com.common.bean.Woman;

/**
 *
 * Created by liyu on 07/12/2017.
 */
public class StaticTest {

    public void sayHello(People people) {
        System.out.println("people say hello");
    }

    public void sayHello(Man man) {
        System.out.println("man say hello");
    }

    public void sayHello(Woman woman) {
        System.out.println("woman say hello");
    }

    public static void main(String[] args) {
        People p1 = new Man();
        People p2 = new Woman();

        StaticTest staticTest = new StaticTest();
        staticTest.sayHello(p1);
        staticTest.sayHello(p2);

        p1 = new Woman();
        staticTest.sayHello(p1);
    }
}
