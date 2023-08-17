package com.datastructure.template.instance.list;

import com.datastructure.template.element.elementinstance.listnode.CirculateLinkedListNode;
import com.datastructure.template.instanceapi.list.CirculateLinkedListApi;
import lombok.Data;

@Data
public class CirculateLinkedList<T> implements CirculateLinkedListApi<T> {

    private int length;

    private CirculateLinkedListNode<T> head;

    public CirculateLinkedList() {
        init(0);
    }

    @Override
    public void init(int length) {
        this.length = length;
        this.head = new CirculateLinkedListNode<T>();
    }

    @Override
    public void clear() {
        this.length = 0;
        CirculateLinkedListNode<T> curNode = this.head.getNext();
        while(curNode != null && curNode != this.head) {
            CirculateLinkedListNode<T> tmpNode = curNode;
            curNode = curNode.getNext();
            tmpNode.destory();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.length==0?true:false;
    }

    @Override
    public T get(int index) {
        if(index <= 0 || index > this.length) {
            return null;
        }
        CirculateLinkedListNode<T> curNode = this.head.getNext();
        for(int i = 1; i <= this.length && curNode != null && curNode != this.head; i++) {
            if(i == index) {
                break;
            }
            curNode = curNode.getNext();
        }
        if(curNode == null || curNode == this.head) {
            return null;
        } else {
            return curNode.getData();
        }
    }

    @Override
    public int get(T data) {
        if(data == null) {
            return 0;
        }
        int index;
        CirculateLinkedListNode<T> curNode = this.head.getNext();
        for(index = 1; index <= this.length && curNode != null && curNode != this.head; index++) {
            if(curNode.getData().equals(data)) {
                break;
            }
            curNode = curNode.getNext();
        }
        if(index > this.length || curNode == null || curNode == this.head) {
            return 0;
        }
        return index;
    }

    @Override
    public boolean contains(T data) {
        return get(data)==0?false:true;
    }

    @Override
    public boolean insert(int index, T data) {
        boolean result = false;
        index = index - 1;
        CirculateLinkedListNode<T> curNode = this.head;
        CirculateLinkedListNode<T> node = new CirculateLinkedListNode<T>();
        node.setData(data);
        if(index < 0 || index > this.length) {
            return false;
        }
        for(int i = 0; i <= this.length && curNode != null; i++) {
            if(i == index) {
                CirculateLinkedListNode<T> tmpNode = curNode.getNext();
                node.setNext(tmpNode);
                curNode.setNext(node);
                this.length += 1;
                result = true;
                break;
            }
            curNode = curNode.getNext();
        }
        return result;
    }

    @Override
    public boolean insert(T data) {
        return insert(this.length + 1, data);
    }

    @Override
    public boolean remove(int index) {
        boolean result = false;
        index = index - 1;
        if(index < 0 || index > this.length - 1) {
            return false;
        }
        CirculateLinkedListNode<T> curNode = this.head;
        for(int i = 0; i < this.length && curNode != null; i++) {
            if(index == i) {
                CirculateLinkedListNode<T> tmpNode = curNode.getNext();
                curNode.setNext(tmpNode.getNext());
                tmpNode.destory();
                result = true;
                this.length -= 1;
                break;
            }
            curNode = curNode.getNext();
        }
        return result;
    }

    @Override
    public boolean remove(T data) {
        boolean result = false;
        if(data == null) {
            return result;
        }
        CirculateLinkedListNode<T> curNode = this.head;
        for(int i = 0; i < this.length && curNode != null; i++) {
            if(curNode.getNext().getData().equals(data)) {
                CirculateLinkedListNode<T> tmpNode = curNode.getNext();
                curNode.setNext(tmpNode.getNext());
                tmpNode.destory();
                this.length -= 1;
                break;
            }
            curNode = curNode.getNext();
        }
        return result;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public void traverse() {
        CirculateLinkedListNode<T> curNode = this.head.getNext();
        for(int i = 1; i <= this.length && curNode != null && curNode != this.head; i++) {
            System.out.println("the " + i + " node address " + curNode.getNext());
            System.out.println("the " + i + " node value " + curNode.getStr());
            curNode = curNode.getNext();
        }
    }
}
