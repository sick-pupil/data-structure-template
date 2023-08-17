package com.datastructure.template.element.elementinstance.stacknode;

import com.datastructure.template.element.elementapi.AbstractNode;

public class LinkedListStackNode<T> extends AbstractNode<T> {

    private LinkedListStackNode<T> next;

    public void setNext(LinkedListStackNode<T> next) {
        this.next = next;
    }

    public LinkedListStackNode<T> getNext() {
        return this.next;
    }
}
