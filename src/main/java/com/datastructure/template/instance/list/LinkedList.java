package com.datastructure.template.instance.list;

import com.datastructure.template.element.elementinstance.listnode.LinkedListNode;
import com.datastructure.template.instanceapi.list.LinkedListApi;
import lombok.Data;

@Data
public class LinkedList<T> implements LinkedListApi<T> {

    private int length;

    private LinkedListNode<T> head;

    public LinkedList() {
        init(0);
    }

    @Override
    public void init(int length) {
        this.length = length;
        this.head = new LinkedListNode<T>();
    }

    @Override
    public void clear() {
        this.length = 0;
        LinkedListNode<T> preNode = head.getNext();
        while(preNode != null) {
            LinkedListNode<T> tmpNode = preNode;
            tmpNode.destory();
            preNode = preNode.getNext();
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
        LinkedListNode<T> curNode = head.getNext();
        for(int i = 1; i <= this.length && curNode != null; i++) {
            if(i == index) {
                break;
            }
            curNode = curNode.getNext();
        }
        if(curNode == null) {
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
        LinkedListNode<T> curNode = head.getNext();
        for(index = 1; index <= this.length && curNode != null; index++) {
            if(curNode.getData().equals(data)) {
                break;
            }
            curNode = curNode.getNext();
        }
        if(index > this.length || curNode == null) {
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
        LinkedListNode<T> curNode = this.head;
        LinkedListNode<T> insertNode = new LinkedListNode<T>();
        insertNode.setData(data);
        if(index < 0 || index > this.length) {
            return false;
        }
        for(int i = 0; i <= this.length && curNode != null; i++) {
            if(i == index) {
                LinkedListNode<T> tmpNode = curNode.getNext();
                insertNode.setNext(tmpNode);
                curNode.setNext(insertNode);
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
        LinkedListNode<T> curNode = this.head;
        for(int i = 0; i < this.length && curNode != null; i++) {
            if(index == i) {
                LinkedListNode<T> tmpNode = curNode.getNext();
                curNode.setNext(tmpNode.getNext());
                tmpNode.destory();
                this.length -= 1;
                result = true;
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
            return false;
        }
        LinkedListNode<T> curNode = this.head;
        for(int i = 0; i < this.length && curNode != null; i++) {
            if(curNode.getNext().getData().equals(data)) {
                LinkedListNode<T> tmpNode = curNode.getNext();
                curNode.setNext(tmpNode.getNext());
                tmpNode.destory();
                this.length -= 1;
                result = true;
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
        LinkedListNode<T> curHead = this.head.getNext();
        for(int i = 1; i <= this.length && curHead != null; i++) {
            System.out.println("the " + i + "node address: " + curHead);
            System.out.println("the " + i + "node value: " + curHead.getStr());
            curHead = curHead.getNext();
        }
    }
}
