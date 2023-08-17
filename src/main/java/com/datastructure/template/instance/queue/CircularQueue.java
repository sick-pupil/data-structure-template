package com.datastructure.template.instance.queue;

import com.datastructure.template.element.elementinstance.queuenode.CircularQueueNode;
import com.datastructure.template.instanceapi.queue.CircularQueueApi;

/**
 * 队空条件：front == rear
 * 队满条件：(rear+1) % length == front
 * 队列长度：(rear—front + length) % length
 */
public class CircularQueue<T> implements CircularQueueApi<T> {

    private int length;

    private int size;

    private int front;

    private int rear;

    private CircularQueueNode<T>[] arr;

    @Override
    public void init(int length) {
        this.length = length;
        this.size = 0;
        this.front = this.rear = 0;
        this.arr = new CircularQueueNode[length];
    }

    @Override
    public void clear() {
        this.size = 0;
        for(int i = 0; i < this.length; i++) {
            this.arr[i] = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.rear?true:false;
    }

    public boolean isFull() {
        return (this.rear+1) % this.length == this.front;
    }

    @Override
    public void enQueue(T data) {
        if(isFull()) {
            return;
        }
        CircularQueueNode<T> node = new CircularQueueNode<>();
        node.setData(data);
        this.arr[this.rear] = node;
        this.rear = (this.rear + 1) % this.length;
        this.size += 1;
    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public T deQueue() {
        if(isEmpty()) {
            return null;
        }
        T result = this.arr[this.front].getData();
        this.front = (this.front + 1) % this.length;
        this.size -= 1;
        return result;
    }

    @Override
    public int length() {
        return (this.rear-this.front + this.length) % this.length;
    }

    @Override
    public void traverse() {

    }
}
