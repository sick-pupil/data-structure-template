package com.datastructure.template.instanceapi.tree;

import com.datastructure.template.element.elementinstance.treenode.LinkedListBinaryTreeNode;

public interface LinkedListBinaryTreeApi<T> {

    void init();

    boolean isEmpty(LinkedListBinaryTreeNode<T> root);

    void clear(LinkedListBinaryTreeNode<T> root);

    LinkedListBinaryTreeNode<T> getRoot();

    T valueOf(LinkedListBinaryTreeNode<T> node);

    LinkedListBinaryTreeNode<T> getNode(LinkedListBinaryTreeNode<T> root, T data);

    boolean setVal(LinkedListBinaryTreeNode<T> node, T newData);

    LinkedListBinaryTreeNode<T> getParent(LinkedListBinaryTreeNode<T> childNode);

    LinkedListBinaryTreeNode<T>[] getChildren(LinkedListBinaryTreeNode<T> parentNode);

    boolean addChild(T childNodeVal, LinkedListBinaryTreeNode<T> parentNode);

    boolean removeChild(T childNodeVal, LinkedListBinaryTreeNode<T> parentNode);

    void traverse(LinkedListBinaryTreeNode<T> node);
}
