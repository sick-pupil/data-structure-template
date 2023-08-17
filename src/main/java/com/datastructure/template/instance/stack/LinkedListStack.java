package com.datastructure.template.instance.stack;

import com.datastructure.template.element.elementinstance.stacknode.LinkedListStackNode;
import com.datastructure.template.instanceapi.stack.LinkedListStackApi;

public class LinkedListStack<T> implements LinkedListStackApi<T> {

    private int length;

    private LinkedListStackNode<T> head;

    public LinkedListStack() {
        init(0);
    }

    @Override
    public void init(int length) {
        this.length = length;
        this.head = new LinkedListStackNode<T>();
    }

    @Override
    public void clear() {
        int size = this.length;
        for(int i = 1; i <= size; i++) {
            pop();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0?true:false;
    }

    @Override
    public void push(T data) {
        LinkedListStackNode<T> node = new LinkedListStackNode();
        LinkedListStackNode<T> firNode = this.head.getNext();
        node.setData(data);
        node.setNext(firNode);
        this.head.setNext(node);
        this.length += 1;
    }

    @Override
    public T pop() {
        T result = null;
        if(this.length == 0) {
            return null;
        } else {
            LinkedListStackNode<T> firNode = this.head.getNext();
            LinkedListStackNode<T> secNode = firNode.getNext();
            result = firNode.getData();
            firNode.destory();
            this.length -= 1;
            this.head.setNext(secNode);
        }
        return result;
    }

    @Override
    public T top() {
        if(this.head.getNext() != null) {
            return this.head.getNext().getData();
        } else {
            return null;
        }
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public void traverse() {
        LinkedListStackNode<T> curNode = this.head.getNext();
        for(int i = 1; i <= this.length && curNode != null; i++) {
            System.out.println("the " + i + "node address: " + curNode);
            System.out.println("the " + i + "node value: " + curNode.getStr());
            curNode = curNode.getNext();
        }
    }
}
