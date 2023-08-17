package com.datastructure.template.instance.tree;

import com.datastructure.template.element.elementinstance.treenode.ChildDiscriptionTreeNode;
import com.datastructure.template.instanceapi.tree.ChildDiscriptionTreeApi;

import java.util.ArrayList;
import java.util.List;

public class ChildDiscriptionTree<T> implements ChildDiscriptionTreeApi<T> {

    private int length;

    private int size;

    private ChildDiscriptionTreeNode<T>[] nodes;

    @Override
    public void init(int length) {
        this.length = length;
        this.size = 0;
        this.nodes = new ChildDiscriptionTreeNode[length];
    }

    @Override
    public boolean isEmpty(int rootIndex) {
        if(this.nodes[rootIndex] == null || rootIndex >= this.length || rootIndex < 0) {
            return true;
        } else {
            return this.nodes[rootIndex].getNextChild()==null?true:false;
        }
    }

    @Override
    public void clear(int rootIndex) {
        if(rootIndex >= this.length || rootIndex < 0 || this.nodes[rootIndex] == null) {
            return;
        }
        ChildDiscriptionTreeNode<T> node = this.nodes[rootIndex];
        ChildDiscriptionTreeNode<T> tmp = node.getNextChild();
        if(tmp == null) {
            this.nodes[rootIndex] = null;
            this.size -= 1;
            return;
        }
        while(tmp != null) {
            clear(tmp.getArrIndex());
            tmp = tmp.getNextChild();
        }
        this.nodes[rootIndex] = null;
        this.size -= 1;
    }

    @Override
    public int getRoot() {
        int resultIndex = -1;
        int flag = 0;
        ChildDiscriptionTreeNode<T> curNode;
        for(int i = 0; i < this.length; i++) {
            curNode = this.nodes[i];
            if(curNode == null) {
                continue;
            } else {
                ChildDiscriptionTreeNode<T> tmpNode;
                for(int j = 0; j < this.length; j++) {
                    tmpNode = this.nodes[j];
                    if(j == i || tmpNode == null || tmpNode.getNextChild() == null) {
                        continue;
                    } else {
                        tmpNode = tmpNode.getNextChild();
                        while(tmpNode != null) {
                            if(tmpNode == curNode) {
                                flag = 0;
                                break;
                            } else {
                                flag = 1;
                                tmpNode = tmpNode.getNextChild();
                            }
                        }
                        if(flag == 1) {
                            break;
                        }
                    }
                }
                if(flag == 1) {
                    resultIndex = curNode.getArrIndex();
                    break;
                }
            }
        }
        return resultIndex;
    }

    @Override
    public T valueOf(int nodeIndex) {
        if(nodeIndex < 0 || nodeIndex >= this.length || this.nodes[nodeIndex] == null) {
            return null;
        } else {
            return this.nodes[nodeIndex].getData();
        }
    }

    @Override
    public int getNode(T data) {
        int resultIndex = -1;
        for(int i = 0; i < this.length; i++) {
            if(this.nodes[i] == null) {
                continue;
            } else {
                if(this.nodes[i].getData().equals(data)) {
                    resultIndex = i;
                    break;
                }
            }
        }
        return resultIndex;
    }

    @Override
    public void setVal(int nodeIndex, T newData) {
        if(nodeIndex < 0 || nodeIndex >= this.length || this.nodes[nodeIndex] == null) {
            return;
        } else {
            this.nodes[nodeIndex].setData(newData);
        }
    }

    @Override
    public int getParent(int nodeIndex) {
        if(nodeIndex < 0 || nodeIndex >= this.length || this.nodes[nodeIndex] == null) {
            return -1;
        } else {
            int flag = 0;
            int resultIndex = -1;
            for(int i = 0; i < this.length; i++) {
                if(this.nodes[i] == null || this.nodes[i].getNextChild() == null) {
                    continue;
                } else {
                    ChildDiscriptionTreeNode<T> parentNode = this.nodes[i];
                    ChildDiscriptionTreeNode<T> curNode = this.nodes[i].getNextChild();
                    while(curNode != null) {
                        if(curNode.getArrIndex() == nodeIndex) {
                            flag = 1;
                            break;
                        }
                        curNode = curNode.getNextChild();
                    }
                    if(flag == 1) {
                        resultIndex = parentNode.getArrIndex();
                        break;
                    }
                }
            }
            return resultIndex;
        }
    }

    @Override
    public int[] getChildren(int nodeIndex) {
        List<Integer> resultChildren = new ArrayList<>();
        if(nodeIndex < 0 || nodeIndex >= this.length
                || this.nodes[nodeIndex] == null
                || this.nodes[nodeIndex].getNextChild() == null) {
            return resultChildren.stream().mapToInt(Integer::valueOf).toArray();
        }
        ChildDiscriptionTreeNode<T> curNode = this.nodes[nodeIndex].getNextChild();
        while(curNode != null) {
            resultChildren.add(curNode.getArrIndex());
            curNode = curNode.getNextChild();
        }
        return resultChildren.stream().mapToInt(Integer::valueOf).toArray();
    }

    @Override
    public boolean addChild(T childNodeVal, int parentIndex) {
        if(parentIndex < 0 || parentIndex >= this.length
                || this.nodes[parentIndex] == null || this.size == this.length) {
            return false;
        }
        ChildDiscriptionTreeNode<T> curNode = this.nodes[parentIndex];
        while(curNode.getNextChild() != null) {
            curNode = curNode.getNextChild();
        }
        ChildDiscriptionTreeNode<T> newNode = new ChildDiscriptionTreeNode<T>();
        newNode.setData(childNodeVal);
        newNode.setNextChild(null);
        curNode.setNextChild(newNode);
        int empIndex = -1;
        for(int i = 0; i < this.length; i++) {
            if(this.nodes[i] == null) {
                empIndex = i;
                break;
            } else {
                continue;
            }
        }
        this.nodes[empIndex] = newNode;
        this.size += 1;
        return true;
    }

    @Override
    public boolean removeChild(T childNodeVal, int parentIndex) {
        if(parentIndex < 0 || parentIndex >= this.length
                || this.nodes[parentIndex] == null || this.size == 0
                || this.nodes[parentIndex].getNextChild() == null) {
            return false;
        }
        int nodeIndex = -1;
        ChildDiscriptionTreeNode<T> curNode = this.nodes[parentIndex].getNextChild();
        while(curNode != null) {
            if(curNode.getData().equals(childNodeVal)) {
                nodeIndex = curNode.getArrIndex();
                break;
            }
            curNode = curNode.getNextChild();
        }
        if(nodeIndex == -1) {
            return false;
        }
        clear(nodeIndex);
        return true;
    }

    @Override
    public void traverse() {
        for(int i = 0; i < this.length; i++) {
            if(this.nodes[i] == null) {
                continue;
            } else {
                System.out.println("the " + i + "node value: " + this.nodes[i].getStr());
            }
        }
    }
}
