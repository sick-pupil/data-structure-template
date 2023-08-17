package com.datastructure.template.element.elementinstance.treenode;

public class ThreadedBinaryTreeNode<T> extends AbstractTreeNode<T> {

    private ThreadedBinaryTreeNode<T> left;

    private ThreadedBinaryTreeNode<T> right;

    private int leftFlag = 0;

    private int rightFlag = 0;

    public ThreadedBinaryTreeNode<T> getLeft() {
        return this.left;
    }

    public void setLeft(ThreadedBinaryTreeNode<T> left) {
        this.left = left;
    }

    public ThreadedBinaryTreeNode<T> getRight() {
        return this.right;
    }

    public void setRight(ThreadedBinaryTreeNode<T> right) {
        this.right = right;
    }

    public int getLeftFlag() {
        return this.leftFlag;
    }

    public void setLeftFlag(int leftFlag) {
        this.leftFlag = leftFlag;
    }

    public int getRightFlag() {
        return this.rightFlag;
    }

    public void setRightFlag(int rightFlag) {
        this.rightFlag = rightFlag;
    }
}
