package com.datastructure.template.element.elementinstance.queuenode;

import com.datastructure.template.element.elementapi.AbstractNode;

public class LinkedListQueueNode<T> extends AbstractNode<T> {

    private LinkedListQueueNode<T> next;

    public LinkedListQueueNode<T> getNext() {
        return this.next;
    }

    public void setNext(LinkedListQueueNode<T> next) {
        this.next = next;
    }

    @Override
    public void destory() {
        this.next = null;
        this.data = null;
    }
}
