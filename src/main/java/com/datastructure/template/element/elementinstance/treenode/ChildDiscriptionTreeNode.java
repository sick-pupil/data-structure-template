package com.datastructure.template.element.elementinstance.treenode;

public class ChildDiscriptionTreeNode<T> extends AbstractTreeNode<T> {

    private ChildDiscriptionTreeNode<T> nextChild;

    private int arrIndex;

    public ChildDiscriptionTreeNode<T> getNextChild() {
        return this.nextChild;
    }

    public void setNextChild(ChildDiscriptionTreeNode<T> nextChild) {
        this.nextChild = nextChild;
    }

    public int getArrIndex() {
        return this.arrIndex;
    }

    public void setArrIndex(int arrIndex) {
        this.arrIndex = arrIndex;
    }

    @Override
    public void destory() {
        this.data = null;
        this.nextChild = null;
        this.arrIndex = -1;
    }
}
