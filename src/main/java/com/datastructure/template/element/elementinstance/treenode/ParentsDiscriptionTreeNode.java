package com.datastructure.template.element.elementinstance.treenode;

public class ParentsDiscriptionTreeNode<T> extends AbstractTreeNode<T> {

    private int parent;

    public int getParent() {
        return this.parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    @Override
    public void destory() {
        this.data = null;
        this.parent = -1;
    }
}
