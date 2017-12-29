package com.java8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 *
 * Created by liyu on 29/12/2017.
 */
public class Lamdba {

    /**
     * () -> {}
     *
     * (x, y) -> {return x + y;}
     * (x, y) -> x + y
     */
    public static void lamdba1() {
        BinaryOperator<Integer> operator1 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };

        BinaryOperator<Integer> operator2 = (x, y) -> x + y;


        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                /** do SomeThing */
            }
        };

        Runnable runnable2 = () -> { /** do SomeThing */ };

        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /** do SomeThing */
            }
        });

        button.addChangeListener(e -> {});
    }

    public static void lamdba2() {
        List<String> list = new ArrayList<>();

        /** 外部循环 */
        for(String str : list) {
            System.out.println(str);
        }

        /** 内部循环 */
        list.forEach(str -> System.out.println(str));

        /** 方法引用 */
        list.forEach(System.out::println);
    }
}
