package com.datastructure.template.element.elementinstance.listnode;

import com.datastructure.template.element.elementapi.AbstractNode;

public class CirculateLinkedListNode<T> extends AbstractNode<T> {

    private CirculateLinkedListNode<T> next;

    public CirculateLinkedListNode<T> getNext() {
        return this.next;
    }

    public void setNext(CirculateLinkedListNode<T> next) {
        this.next = next;
    }

    @Override
    public void destory() {
        this.next = null;
        this.data = null;
    }
}
