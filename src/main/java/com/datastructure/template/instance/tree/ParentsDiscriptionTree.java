package com.datastructure.template.instance.tree;

import com.datastructure.template.element.elementinstance.treenode.ParentsDiscriptionTreeNode;
import com.datastructure.template.instanceapi.tree.ParentsDiscriptionTreeApi;

import java.util.ArrayList;
import java.util.List;

public class ParentsDiscriptionTree<T> implements ParentsDiscriptionTreeApi<T> {

    private int length;

    private int size;

    private ParentsDiscriptionTreeNode<T>[] nodeArr;

    @Override
    public void init(int length) {
        this.length = length;
        this.size = 0;
        this.nodeArr = new ParentsDiscriptionTreeNode[length];
    }

    @Override
    public boolean isEmpty(int rootIndex) {
        return this.size==0?true:false;
    }

    @Override
    public void clear(int rootIndex) {
        int[] childrenIndex = getChildren(rootIndex);
        if(childrenIndex.length != 0) {
            for(int childIndex: childrenIndex) {
                getChildren(childIndex);
            }
        } else {
            this.nodeArr[rootIndex] = null;
        }
        this.size = 0;
    }

    @Override
    public int getRoot() {
        int index = -1;
        for(int i = 0; i < this.length; i++) {
            if(this.nodeArr[i] == null) {
                continue;
            } else {
                if(this.nodeArr[i].getParent() == -1) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    @Override
    public T valueOf(int nodeIndex) {
        return this.nodeArr[nodeIndex].getData();
    }

    @Override
    public int getNode(T data) {
        int index = -1;
        for(int i = 0; i < this.length; i++) {
            if(this.nodeArr[i] == null) {
                continue;
            } else {
                if(this.nodeArr[i].getData().equals(data)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    @Override
    public void setVal(int nodeIndex, T newData) {
        this.nodeArr[nodeIndex].setData(newData);
    }

    @Override
    public int getParent(int nodeIndex) {
        return this.nodeArr[nodeIndex].getParent();
    }

    @Override
    public int[] getChildren(int nodeIndex) {
        List<Integer> tmp = new ArrayList<Integer>();
        for(int i = 0; i < this.length; i++) {
            if(this.nodeArr[i] == null) {
                continue;
            } else {
                if(this.nodeArr[i].getParent() == nodeIndex) {
                    tmp.add(i);
                }
            }
        }
        return tmp.stream().mapToInt(Integer::valueOf).toArray();
    }

    @Override
    public boolean addChild(T childNodeVal, int parentIndex) {
        if(this.size == this.length) {
            return false;
        } else {
            int empIndex = -1;
            for(int i = 0; i < this.length; i++) {
                if(this.nodeArr[i] == null) {
                    empIndex = i;
                    break;
                }
            }
            ParentsDiscriptionTreeNode<T> childNode = new ParentsDiscriptionTreeNode<T>();
            childNode.setData(childNodeVal);
            childNode.setParent(parentIndex);
            this.nodeArr[empIndex] = childNode;
            size += 1;
            return true;
        }
    }

    @Override
    public boolean removeChild(T childNodeVal, int parentIndex) {
        int[] childrenIndex = getChildren(parentIndex);
        int removeIndex = -1;
        for(int childIndex: childrenIndex) {
            if(this.nodeArr[childIndex].getData().equals(childNodeVal)) {
                removeIndex = childIndex;
                break;
            }
        }
        if(removeIndex != -1) {
            this.nodeArr[removeIndex] = null;
            this.size -= 1;
        }
        return true;
    }

    @Override
    public void traverse() {
        for(int i = 0; i < this.length; i++) {
            if(this.nodeArr[i] == null) {
                continue;
            } else {
                System.out.println("the " + i + "node parent: " + this.nodeArr[i].getParent());
                System.out.println("the " + i + "node value: " + this.nodeArr[i].getStr());
            }
        }
    }
}
