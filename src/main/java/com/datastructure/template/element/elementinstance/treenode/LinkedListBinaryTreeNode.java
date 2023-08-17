package com.datastructure.template.element.elementinstance.treenode;

public class LinkedListBinaryTreeNode<T> extends AbstractTreeNode<T> {

    private LinkedListBinaryTreeNode<T> leftChild;

    private LinkedListBinaryTreeNode<T> rightChild;

    public LinkedListBinaryTreeNode<T> getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(LinkedListBinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public LinkedListBinaryTreeNode<T> getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(LinkedListBinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public void destory() {
        this.data = null;
        this.leftChild = null;
        this.rightChild = null;
    }
}
