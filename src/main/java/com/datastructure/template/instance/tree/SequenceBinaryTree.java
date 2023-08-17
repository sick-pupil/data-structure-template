package com.datastructure.template.instance.tree;

import com.datastructure.template.element.elementinstance.treenode.SequenceBinaryTreeNode;
import com.datastructure.template.instanceapi.tree.SequenceBinaryTreeApi;

import java.util.ArrayList;
import java.util.List;

public class SequenceBinaryTree<T> implements SequenceBinaryTreeApi<T> {

    private int size;

    private int length;

    private SequenceBinaryTreeNode<T>[] arr;

    @Override
    public void init(int length) {
        this.length = length;
        this.size = 0;
        this.arr = new SequenceBinaryTreeNode[length];
    }

    @Override
    public boolean isEmpty(int rootIndex) {
        if(rootIndex < 0 || rootIndex >= this.length || this.arr[rootIndex] == null) {
            return true;
        }
        int leftChildIndex = rootIndex * 2;
        int rightChildIndex = rootIndex * 2 + 1;
        boolean hasLeft = true, hasRight = true;
        if(leftChildIndex < 0 || leftChildIndex > this.length - 1) {
            hasLeft = false;
        }
        if(rightChildIndex < 0 || rightChildIndex > this.length - 1) {
            hasRight = false;
        }
        if(hasLeft == false && hasRight == false) {
            return true;
        }
        if(hasLeft == true && this.arr[leftChildIndex] != null) {
            return false;
        } else if (hasRight == true && this.arr[rightChildIndex] != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void clear(int rootIndex) {
        if(rootIndex < 0 || rootIndex >= this.length || this.arr[rootIndex] == null) {
            return;
        }
        int leftChildIndex = rootIndex * 2;
        int rightChildIndex = rootIndex * 2 + 1;
        boolean hasLeft = true, hasRight = true;
        if(leftChildIndex < 0 || leftChildIndex > this.length - 1) {
            hasLeft = false;
        }
        if(rightChildIndex < 0 || rightChildIndex > this.length - 1) {
            hasRight = false;
        }
        if(hasLeft == false && hasRight == false) {
            return;
        }
        if(hasLeft == true && this.arr[leftChildIndex] != null) {
            clear(leftChildIndex);
            this.arr[leftChildIndex] = null;
        }
        if(hasRight == true && this.arr[rightChildIndex] != null) {
            clear(rightChildIndex);
            this.arr[rightChildIndex] = null;
        }
    }

    @Override
    public int getRoot() {
        return 0;
    }

    @Override
    public T valueOf(int nodeIndex) {
        if(nodeIndex < 0 || nodeIndex >= this.length || this.arr[nodeIndex] == null) {
            return null;
        } else {
            return this.arr[nodeIndex].getData();
        }
    }

    @Override
    public int getNode(T data) {
        return 0;
    }

    @Override
    public void setVal(int nodeIndex, T newData) {
        if(nodeIndex < 0 || nodeIndex >= this.length || this.arr[nodeIndex] == null) {
            return;
        } else {
            this.arr[nodeIndex].setData(newData);
        }
    }

    @Override
    public int getParent(int nodeIndex) {
        if(nodeIndex < 0 || nodeIndex >= this.length || this.arr[nodeIndex] == null) {
            return -1;
        }
        int parentIndex = -1;
        if(nodeIndex % 2 == 0) {
            parentIndex = (nodeIndex - 1) / 2;
        } else {
            parentIndex = nodeIndex / 2;
        }
        return parentIndex;
    }

    @Override
    public int[] getChildren(int nodeIndex) {
        if(isEmpty(nodeIndex)) {
            return null;
        } else {
            List<Integer> childrenList = new ArrayList<>();
            int leftChildIndex = nodeIndex * 2;
            int rightChildIndex = nodeIndex * 2 + 1;
            boolean hasLeft = true, hasRight = true;
            if(leftChildIndex < 0 || leftChildIndex > this.length - 1 || this.arr[leftChildIndex] == null) {
                hasLeft = false;
            }
            if(rightChildIndex < 0 || rightChildIndex > this.length - 1 || this.arr[rightChildIndex] == null) {
                hasRight = false;
            }
            if(hasLeft == true) {
                childrenList.add(leftChildIndex);
            }
            if(hasRight == true) {
                childrenList.add(rightChildIndex);
            }
            return childrenList.stream().mapToInt(Integer::valueOf).toArray();
        }
    }

    @Override
    public boolean addChild(T childNodeVal, int parentIndex) {
        if(parentIndex < 0 || parentIndex >= this.length || this.arr[parentIndex] == null) {
            return false;
        } else {
            int leftChildIndex = parentIndex * 2;
            int rightChildIndex = parentIndex * 2 + 1;
            boolean outStageLeft = false, outStageRight = false;
            if(leftChildIndex < 0 || leftChildIndex > this.length - 1) {
                outStageLeft = true;
            }
            if(rightChildIndex < 0 || rightChildIndex > this.length - 1) {
                outStageRight = true;
            }
            SequenceBinaryTreeNode<T> node = new SequenceBinaryTreeNode<>();
            node.setData(childNodeVal);
            node.setLeft(-1);
            node.setRight(-1);
            if(outStageLeft == false && this.arr[leftChildIndex] == null) {
                this.arr[leftChildIndex] = node;
                return true;
            }
            else if(outStageRight == false && this.arr[rightChildIndex] == null) {
                this.arr[rightChildIndex] = node;
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean removeChild(T childNodeVal, int parentIndex) {
        if(parentIndex < 0 || parentIndex >= this.length || this.arr[parentIndex] == null) {
            return false;
        } else {
            int leftChildIndex = parentIndex * 2;
            int rightChildIndex = parentIndex * 2 + 1;
            boolean outStageLeft = false, outStageRight = false;
            if(leftChildIndex < 0 || leftChildIndex > this.length - 1) {
                outStageLeft = true;
            }
            if(rightChildIndex < 0 || rightChildIndex > this.length - 1) {
                outStageRight = true;
            }
            if(outStageLeft == false && this.arr[leftChildIndex] != null
                    && this.arr[leftChildIndex].getData().equals(childNodeVal)) {
                clear(leftChildIndex);
                this.arr[leftChildIndex] = null;
                return true;
            } else if(outStageRight == false && this.arr[rightChildIndex] != null
                    && this.arr[rightChildIndex].getData().equals(childNodeVal)) {
                clear(rightChildIndex);
                this.arr[rightChildIndex] = null;
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public void traverse(int nodeIndex) {
        SequenceBinaryTreeNode<T> node = this.arr[nodeIndex];
        int leftChildIndex = node.getLeft();
        int rightChildIndex = node.getRight();
        System.out.println("the " + nodeIndex + "node val: " + this.arr[nodeIndex].getStr());
        System.out.println("the " + nodeIndex + "node left child: " + this.arr[nodeIndex].getLeft());
        System.out.println("the " + nodeIndex + "node right child: " + this.arr[nodeIndex].getRight());
        if(leftChildIndex < 0 || leftChildIndex >= this.length || this.arr[leftChildIndex] == null) {
            return;
        } else {
            traverse(leftChildIndex);
        }
        if(rightChildIndex < 0 || rightChildIndex >= this.length || this.arr[rightChildIndex] == null) {
            traverse(rightChildIndex);
        }
    }
}
