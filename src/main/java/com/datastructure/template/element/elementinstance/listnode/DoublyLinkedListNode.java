package com.datastructure.template.element.elementinstance.listnode;

import com.datastructure.template.element.elementapi.AbstractNode;

public class DoublyLinkedListNode<T> extends AbstractNode<T> {

    private DoublyLinkedListNode<T> next;

    private DoublyLinkedListNode<T> pre;

    public DoublyLinkedListNode<T> getNext() {
        return this.next;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }

    public DoublyLinkedListNode<T> getPre() {
        return this.pre;
    }

    public void setPre(DoublyLinkedListNode<T> pre) {
        this.pre = pre;
    }

    @Override
    public void destory() {
        this.next = null;
        this.pre = null;
        this.data = null;
    }
}
