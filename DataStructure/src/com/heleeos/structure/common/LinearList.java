package com.heleeos.structure.common;

/**
 * 线性表数据结构
 * Created by liyu on 21/01/2018.
 */
public interface LinearList<T> {

    /**
     * 插入一个元素
     * @param t 元素
     */
    boolean insert(T t);

    /**
     * 删除指定位置的元素
     * @param index 位置
     */
    T delete(int index);

    /**
     * 获取指定位置的元素
     * @param index 位置
     */
    T get(int index);

    /**
     * 查找元素所在的位置
     * @param t 元素
     */
    int locate(T t);

    /**
     * 线性表是否为空
     */
    boolean isEmpty();
}
