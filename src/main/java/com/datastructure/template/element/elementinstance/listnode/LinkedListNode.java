package com.datastructure.template.element.elementinstance.listnode;

import com.datastructure.template.element.elementapi.AbstractNode;

public class LinkedListNode<T> extends AbstractNode<T> {

    private LinkedListNode<T> next;

    public LinkedListNode<T> getNext() {
        return this.next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    @Override
    public void destory() {
        this.next = null;
        this.data = null;
    }
}
