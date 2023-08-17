package com.datastructure.template.instance.queue;

import com.datastructure.template.element.elementinstance.queuenode.LinkedListQueueNode;
import com.datastructure.template.instanceapi.queue.LinkedListQueueApi;

public class LinkedListQueue<T> implements LinkedListQueueApi<T> {

    private int length;

    private LinkedListQueueNode<T> head;

    public LinkedListQueue() {
        init(0);
    }

    @Override
    public void init(int length) {
        this.length = length;
        this.head = new LinkedListQueueNode<>();
    }

    @Override
    public void clear() {
        LinkedListQueueNode<T> curNode = this.head.getNext();
        while(curNode != null) {
            LinkedListQueueNode<T> tmpNode = curNode;
            curNode = curNode.getNext();
            tmpNode.destory();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.length==0?true:false;
    }

    @Override
    public void enQueue(T data) {
        LinkedListQueueNode<T> curNode = this.head.getNext();
        for(int i = 1; i < this.length && curNode != null; i++) {
            curNode = curNode.getNext();
        }
        LinkedListQueueNode<T> node = new LinkedListQueueNode<>();
        node.setData(data);
        node.setNext(null);
        curNode.setNext(node);
        this.length += 1;
    }

    @Override
    public boolean contains(T data) {
        boolean result = false;
        LinkedListQueueNode<T> curNode = this.head.getNext();
        while(curNode != null) {
            if(curNode.getData().equals(data)) {
                result = true;
                break;
            }
            LinkedListQueueNode<T> tmpNode = curNode;
            curNode = curNode.getNext();
        }
        return result;
    }

    @Override
    public T deQueue() {
        LinkedListQueueNode<T> firNode = this.head.getNext();
        if(this.length == 0) {
            return null;
        } else {
            LinkedListQueueNode<T> secNode = firNode.getNext();
            this.head.setNext(secNode);
            T result = firNode.getData();
            firNode.destory();
            this.length -= 1;
            return result;
        }
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public void traverse() {
        LinkedListQueueNode<T> curNode = this.head.getNext();
        for(int i = 1; i <= this.length && curNode != null; i++) {
            System.out.println("the " + i + "node address: " + curNode);
            System.out.println("the " + i + "node value: " + curNode.getStr());
            curNode = curNode.getNext();
        }
    }
}
