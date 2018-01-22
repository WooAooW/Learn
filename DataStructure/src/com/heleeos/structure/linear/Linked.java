package com.heleeos.structure.linear;

import com.heleeos.structure.common.LinearList;

/**
 * 线性表 - 链式存储
 * Created by liyu on 21/01/2018.
 */
public class Linked<T> implements LinearList<T> {

    /**
     * 链表中的头指针
     */
    private Node<T> head;

    @Override
    public boolean insert(T t) {
        if(head == null) {
            head = new Node<>(t);
            return true;
        }

        Node<T> temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<>(t);

        return true;
    }

    @Override
    public T delete(int index) {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int locate(T t) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * 链表中的元素
     */
    private class Node<T> {

        private T t;

        private Node<T> next;

        Node(T t) {
            this.t = t;
        }
    }
}
