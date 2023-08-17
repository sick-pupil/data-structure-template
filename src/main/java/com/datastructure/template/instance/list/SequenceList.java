package com.datastructure.template.instance.list;

import com.datastructure.template.element.elementinstance.listnode.SequenceListNode;
import com.datastructure.template.instanceapi.list.SequenceListApi;

public class SequenceList<T> implements SequenceListApi<T> {

    private int length;

    private int size;

    private SequenceListNode<T>[] head;

    public SequenceList(int length) {
        this.length = length;
        this.size = 0;
        this.head = new SequenceListNode[length];
    }

    @Override
    public void init(int length) {
        this.length = length;
        this.size = 0;
        this.head = new SequenceListNode[this.length];
    }

    @Override
    public void clear() {
        this.size = 0;
        for(int i = 0; i < this.size; i++) {
            this.head[i] = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size==0?true:false;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > this.size - 1) {
            return null;
        }
        return this.head[index].getData();
    }

    @Override
    public int get(T data) {
        int i;
        for(i = 0; i < this.size; i++) {
            if(this.head[i].getData().equals(data)) {
                break;
            }
        }
        if(i == this.size) {
            return -1;
        }
        return i;
    }

    @Override
    public boolean contains(T data) {
        return get(data)==-1?false:true;
    }

    @Override
    public boolean insert(int index, T data) {
        if(index < 0 || (index <= this.length - 1 && index > this.size) || this.size == this.length) {
            return false;
        }
        SequenceListNode<T> node = new SequenceListNode<T>();
        node.setData(data);
        if(index == this.size) {
            this.head[index] = node;
        } else {
            for(int i = this.size - 1; i >= index; i--) {
                this.head[i+1] = this.head[i];
            }
            this.head[index] = node;
        }
        this.size += 1;
        return true;
    }

    @Override
    public boolean insert(T data) {
        return insert(this.size, data);
    }

    @Override
    public boolean remove(int index) {
        if(index < 0 || index > this.size - 1 || this.size == 0) {
            return false;
        }
        for(int i = index + 1; i < this.size; i++) {
            this.head[i-1] = this.head[i];
        }
        this.head[size - 1] = null;
        this.size -= 1;
        return true;
    }

    @Override
    public boolean remove(T data) {
        int index = get(data);
        return remove(index);
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public void traverse() {
        for(int i = 0; i < this.size; i++) {
            System.out.println("the " + i + "node address: " + this.head[i]);
            System.out.println("the " + i + "node value: " + this.head[i].getStr());
        }
    }
}
