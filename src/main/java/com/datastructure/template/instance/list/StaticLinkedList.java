package com.datastructure.template.instance.list;

import com.datastructure.template.element.elementinstance.listnode.StaticLinkedListNode;
import com.datastructure.template.instanceapi.list.StaticLinkedListApi;

public class StaticLinkedList<T> implements StaticLinkedListApi<T> {

    private int length;

    private int size;

    private StaticLinkedListNode<T>[] arr;

    public StaticLinkedList(int length) {
        init(length);
    }

    @Override
    public void init(int length) {
        if(length <= 2) {
            return;
        }
        this.length = length;
        this.size = 0;
        arr = new StaticLinkedListNode[length];
        for(int i = 0; i < this.length; i++) {
            arr[i] = new StaticLinkedListNode();
            if(i == this.length - 1) {
                this.arr[i].setCur(-1);
                this.arr[i].setData(null);
            } else if(i >= 0 && i < this.length - 2) {
                this.arr[i].setCur(i + 1);
                this.arr[i].setData(null);
            } else {
                this.arr[i].setCur(-1);
                this.arr[i].setData(null);
            }
        }
    }

    @Override
    public void clear() {
        this.size = 0;
        for(int i = 0; i < this.length; i++) {
            if(i == this.length - 1) {
                this.arr[i].setCur(-1);
                this.arr[i].setData(null);
            } else if(i >= 0 && i < this.length - 2) {
                this.arr[i].setCur(i + 1);
                this.arr[i].setData(null);
            } else {
                this.arr[i].setCur(-1);
                this.arr[i].setData(null);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size==0?true:false;
    }

    @Override
    public T get(int index) {
        int currentCur = this.arr[this.length - 1].getCur();
        StaticLinkedListNode<T> tmpNode = null;
        for(int i = 1; i <= index && currentCur != -1; i++) {
            tmpNode = this.arr[currentCur];
            currentCur = tmpNode.getCur();
        }
        if(currentCur == -1) {
            return null;
        } else {
            return tmpNode.getData();
        }
    }

    @Override
    public int get(T data) {
        int index = 1;
        int currentCur = this.arr[this.length - 1].getCur();
        StaticLinkedListNode<T> tmpNode = null;
        while(currentCur != -1) {
            tmpNode = this.arr[currentCur];
            if(data == tmpNode.getData()) {
                break;
            }
            currentCur = tmpNode.getCur();
            index += 1;
        }
        if(currentCur == -1) {
            return -1;
        } else {
            return index;
        }
    }

    @Override
    public boolean contains(T data) {
        return get(data)==-1?false:true;
    }

    @Override
    public boolean insert(int index, T data) {
        boolean result = false;
        if(this.arr[0].getCur() == -1 || index > this.size + 1 || index <= 0) {
            return result;
        }
        int currentCur = this.arr[this.length - 1].getCur();
        StaticLinkedListNode<T> node = new StaticLinkedListNode<T>();
        node.setData(data);
        //在链表末尾插入元素
        if(index == this.size + 1) {
            //为空链表则直接在头部插入
            if(this.size == 0) {
                int empIndex = this.arr[0].getCur();
                int nextEmpIndex = this.arr[empIndex].getCur();
                node.setCur(-1);
                this.arr[empIndex] = node;
                this.arr[0].setCur(nextEmpIndex);
                this.arr[this.length - 1].setCur(empIndex);
                this.size += 1;
                result = true;
            }
            //链表存在元素则遍历元素插入
            else {
                while(currentCur != -1 && this.arr[currentCur].getCur() != -1) {
                    currentCur = this.arr[currentCur].getCur();
                }
                //currentCur为最后一个元素的下标
                //empIndex为第一个空余元素下标
                //nextEmpIndex为第二个空余元素下标
                int empIndex = this.arr[0].getCur();
                int nextEmpIndex = this.arr[this.arr[0].getCur()].getCur();
                node.setCur(-1);
                this.arr[empIndex] = node;
                this.arr[currentCur].setCur(empIndex);
                this.arr[0].setCur(nextEmpIndex);
                this.size += 1;
                result = true;
            }
        }
        //在链表中存在元素的位置插入
        else if(index >= 1 && index <= this.size) {
            //插入头部
            if(index == 1) {
                //empIndex为第一个空余元素下标
                //nextEmpIndex为第二个空余元素下标
                //firIndex为第一个元素下标
                int empIndex = this.arr[0].getCur();
                int nextEmpIndex = this.arr[empIndex].getCur();
                int firIndex = this.arr[this.length - 1].getCur();
                node.setCur(firIndex);
                this.arr[empIndex] = node;
                this.arr[this.length - 1].setCur(empIndex);
                this.arr[0].setCur(nextEmpIndex);
                this.size += 1;
                result = true;
            }
            //插入非头部
            else {
                int i = 1;
                while(currentCur != -1) {
                    if(i + 1 == index) {
                        //currentCur为插入下标的前一下标
                        //insertIndex为插入下标
                        //empIndex为第一个空闲元素下标
                        //nextEmpIndex为第二个空闲元素下标
                        int empIndex = this.arr[0].getCur();
                        int nextEmpIndex = this.arr[empIndex].getCur();
                        int insertIndex = this.arr[currentCur].getCur();
                        node.setCur(insertIndex);
                        this.arr[empIndex] = node;
                        this.arr[currentCur].setCur(empIndex);
                        this.arr[0].setCur(nextEmpIndex);
                        break;
                    } else {
                        i += 1;
                        currentCur = this.arr[currentCur].getCur();
                    }
                }
                this.size += 1;
                result = true;
            }
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public boolean insert(T data) {
        if(this.size == 0) {
            return insert(1, data);
        } else {
            return insert(this.size + 1, data);
        }
    }

    @Override
    public boolean remove(int index) {
        boolean result = false;
        int currentCur = this.arr[this.length - 1].getCur();
        if(currentCur == -1 || index > this.size) {
            return result;
        }
        //获取currentCur为删除元素的前一个下标
        //removeIndex为删除元素的下标
        //empIndex为第一个空余元素的下标
        //firIndex为第一个元素下标
        //secIndex为第一个元素下标
        int removeIndex = this.arr[currentCur].getCur();
        int aftRemoveIndex = this.arr[removeIndex].getCur();
        int empIndex = this.arr[0].getCur();
        int firIndex = this.arr[this.length - 1].getCur();
        int secIndex = this.arr[firIndex].getCur();
        if(index == 1) {
            this.arr[0].setCur(firIndex);
            this.arr[firIndex].setCur(empIndex);
            this.arr[this.length - 1].setCur(secIndex);
        } else {
            for(int i = 1; i < index - 1 && currentCur != -1; i++) {
                currentCur = this.arr[currentCur].getCur();
            }
            this.arr[currentCur].setCur(aftRemoveIndex);
            this.arr[0].setCur(removeIndex);
            this.arr[removeIndex].setCur(empIndex);
        }
        size -= 1;
        return result = true;
    }

    @Override
    public boolean remove(T data) {
        boolean result = false;
        int currentCur = this.arr[this.length - 1].getCur();
        if(currentCur == -1) {
            return result;
        }
        for(int i = 1; i <= this.size && currentCur != -1; i++) {
            int nextIndex = this.arr[currentCur].getCur();
            if(this.arr[currentCur].equals(data) && i == 1) {
                int empIndex = this.arr[0].getCur();
                int secIndex = this.arr[currentCur].getCur();
                this.arr[currentCur].setCur(empIndex);
                this.arr[0].setCur(currentCur);
                this.arr[this.length - 1].setCur(secIndex);
                result = true;
                break;
            }
            if(nextIndex != -1 && this.arr[nextIndex].equals(data)) {
                int empIndex = this.arr[0].getCur();
                int aftRemoveIndex = this.arr[nextIndex].getCur();
                this.arr[currentCur].setCur(aftRemoveIndex);
                this.arr[nextIndex].setCur(empIndex);
                this.arr[0].setCur(nextIndex);
                result = true;
                break;
            }
            currentCur = this.arr[currentCur].getCur();
        }
        return result;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public void traverse() {
        int currentCur = this.arr[this.length - 1].getCur();
        StaticLinkedListNode<T> tmpNode;
        while(currentCur != -1) {
            tmpNode = this.arr[currentCur];
            System.out.println("the " + currentCur + " node address " + tmpNode.toString());
            System.out.println("the " + currentCur + " node value " + tmpNode.getStr());
            currentCur = tmpNode.getCur();
        }
    }
}
