package com.datastructure.template.element.elementinstance.treenode;

public class SequenceBinaryTreeNode<T> extends AbstractTreeNode<T> {

    private int left;

    private int right;

    public void setLeft(int left) {
        this.left = left;
    }

    public int getLeft() {
        return this.left;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getRight() {
        return this.right;
    }

    @Override
    public void destory() {
        this.data = null;
        this.left = -1;
        this.right = -1;
    }
}
