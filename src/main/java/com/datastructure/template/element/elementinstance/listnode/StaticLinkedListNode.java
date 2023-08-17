package com.datastructure.template.element.elementinstance.listnode;

import com.datastructure.template.element.elementapi.AbstractNode;

public class StaticLinkedListNode<T> extends AbstractNode<T> {

    private int cur;

    public int getCur() {
        return this.cur;
    }

    public void setCur(int cur) {
        this.cur = cur;
    }
}
