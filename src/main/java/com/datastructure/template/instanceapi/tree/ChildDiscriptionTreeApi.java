package com.datastructure.template.instanceapi.tree;

public interface ChildDiscriptionTreeApi<T> {

    void init(int length);

    boolean isEmpty(int rootIndex);

    void clear(int rootIndex);

    int getRoot();

    T valueOf(int nodeIndex);

    int getNode(T data);

    void setVal(int nodeIndex, T newData);

    int getParent(int nodeIndex);

    int[] getChildren(int nodeIndex);

    boolean addChild(T childNodeVal, int parentIndex);

    boolean removeChild(T childNodeVal, int parentIndex);

    void traverse();
}
