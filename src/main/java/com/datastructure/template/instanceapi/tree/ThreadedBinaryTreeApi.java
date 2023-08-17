package com.datastructure.template.instanceapi.tree;

import com.datastructure.template.element.elementinstance.treenode.ThreadedBinaryTreeNode;

public interface ThreadedBinaryTreeApi<T> {

    void init();

    boolean isEmpty(ThreadedBinaryTreeNode<T> root);

    void clear(ThreadedBinaryTreeNode<T> root);

    ThreadedBinaryTreeNode<T> getRoot();

    T valueOf(ThreadedBinaryTreeNode<T> node);

    ThreadedBinaryTreeNode<T> getNode(ThreadedBinaryTreeNode<T> root, T data);

    boolean setVal(ThreadedBinaryTreeNode<T> node, T newData);

    ThreadedBinaryTreeNode<T> getParent(ThreadedBinaryTreeNode<T> childNode);

    ThreadedBinaryTreeNode<T>[] getChildren(ThreadedBinaryTreeNode<T> parentNode);

    boolean addChild(T childNodeVal, ThreadedBinaryTreeNode<T> parentNode);

    boolean removeChild(T childNodeVal, ThreadedBinaryTreeNode<T> parentNode);

    void traverse(ThreadedBinaryTreeNode<T> node);

    void inThreadByInOrder();
}
