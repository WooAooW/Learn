package com.heleeos.change.spring4_0;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.heleeos.common.config.TestConfig;

/**
 * Spring 4.0 支持泛型的自动注入.
 * 如果存在子类的泛型实现,则自动注入.
 * 
 * @author liyu
 */
public class TestAutowired extends TestConfig {

    /*
     *  因为存在多个相同的 StringList实例,所以会报
     *  No qualifying bean of type [com.helios.change.ComputeList] is defined: expected single matching bean but found 2: getString,getString2
     */
    //@Autowired
    //private ComputeList<String> list1;
    
    @Autowired
    private ComputeList<Integer> list2;
    
    @Autowired
    private List<ComputeList<String>> lists;
    
    @Test
    public void test() {
        System.out.println(String.format("%s is null? %b", "list2", list2 == null));
        System.out.println(String.format("%s is null? %b", "lists", lists == null));
        if(list2 != null) System.out.println("list2:" + list2.output());
        if(lists != null) lists.forEach((list) -> System.out.println("lists 中的:" + list.output()));
    }
}

/**
 * 泛型接口 
 */
interface ComputeList<T> {
    @SuppressWarnings("unchecked")
    public ComputeList<T> input(T...ts);
    public T output();
}

class StringList implements ComputeList<String> {

    private String result = null;
    
    @Override
    public StringList input(String...strs) {
        StringBuffer buffer = new StringBuffer();
        for(String str : strs) {
            buffer.append(str);
        }
        result = buffer.toString();
        return this;
    }
    
    @Override
    public String output() {
        return result;
    }
}

class IntegerList implements ComputeList<Integer> {

    private Integer result = null;
    
    @Override
    public IntegerList input(Integer... numbers) {
        int sum = 0;
        for(Integer number : numbers) {
            sum += number;
        }
        result = sum;
        return this;
    }
    
    @Override
    public Integer output() {
        return result;
    }
}

@Configuration
class ListsBeans {
    
    /* StringList 等同于  ComputeList<String> */
    @Bean
    public StringList getString() {
        return new StringList().input("I'm", " ", "now", " ", "learn Spring");
    }
    
    @Bean
    public StringList getString2() {
        return new StringList().input("This", " is second", " String List");
    }
    
    /* IntegerList 等同于  ComputeList<Integer> */
    @Bean
    public IntegerList getInt() {
        return new IntegerList().input(15, 98, -5);
    }
}