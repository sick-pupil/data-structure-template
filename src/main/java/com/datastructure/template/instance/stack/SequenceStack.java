package com.datastructure.template.instance.stack;

import com.datastructure.template.element.elementinstance.stacknode.SequenceStackNode;
import com.datastructure.template.instanceapi.stack.SequenceStackApi;

public class SequenceStack<T> implements SequenceStackApi<T> {

    private int length;

    private SequenceStackNode<T>[] stack;

    @Override
    public void init(int length) {
        this.length = length;
        this.stack = new SequenceStackNode[length];
    }

    @Override
    public void clear() {
        for(int i = 1; i <= this.length; i++) {
            pop();
        }
    }

    @Override
    public boolean isEmpty() {
        return length()==0?true:false;
    }

    @Override
    public void push(T data) {
        if(this.length == this.stack.length) {
            return;
        }
        this.length += 1;
        SequenceStackNode<T> node = new SequenceStackNode<>();
        node.setData(data);
        this.stack[this.length - 1] = node;
    }

    @Override
    public T pop() {
        if(this.length == 0) {
            return null;
        }
        T data = this.stack[this.length - 1].getData();
        this.stack[this.length - 1] = null;
        this.length -= 1;
        return data;
    }

    @Override
    public T top() {
        return this.stack[this.length - 1].getData();
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public void traverse() {
        for(int i = 0; i < this.length; i++) {
            System.out.println("the " + i + "node address: " + this.stack[i]);
            System.out.println("the " + i + "node value: " + this.stack[i].getStr());
        }
    }
}
