package com.datastructure.template.instance.tree;

import com.datastructure.template.element.elementinstance.treenode.ThreadedBinaryTreeNode;
import com.datastructure.template.instanceapi.tree.ThreadedBinaryTreeApi;

import java.util.ArrayList;
import java.util.List;

public class ThreadedBinaryTree<T> implements ThreadedBinaryTreeApi<T> {

    private ThreadedBinaryTreeNode<T> root;

    private ThreadedBinaryTreeNode<T> preNode;

    private int size;

    @Override
    public void init() {
        this.size = 1;
        this.root = new ThreadedBinaryTreeNode<T>();
        this.preNode = null;
    }

    @Override
    public boolean isEmpty(ThreadedBinaryTreeNode<T> root) {
        if(root.getLeft() != null || root.getRight() != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear(ThreadedBinaryTreeNode<T> root) {
        this.size = 0;
        if(root != null && root.getLeft() == null && root.getRight() == null) {
            root = null;
            return;
        } else if(root != null && (root.getLeft() != null || root.getRight() != null)) {
            ThreadedBinaryTreeNode<T> leftChild = root.getLeft();
            ThreadedBinaryTreeNode<T> rightChild = root.getRight();
            if(leftChild != null) {
                clear(leftChild);
            }
            if(rightChild != null) {
                clear(rightChild);
            }
            root = null;
        } else {
            return;
        }
    }

    @Override
    public ThreadedBinaryTreeNode<T> getRoot() {
        return this.root;
    }

    @Override
    public T valueOf(ThreadedBinaryTreeNode<T> node) {
        return node.getData();
    }

    @Override
    public ThreadedBinaryTreeNode<T> getNode(ThreadedBinaryTreeNode<T> root, T data) {
        ThreadedBinaryTreeNode<T> resultNode = null;
        if(root != null && root.getLeft() == null && root.getRight() == null) {
            if(root.getData().equals(data)) {
                resultNode = root;
            }
        } else if(root != null && (root.getLeft() != null || root.getRight() != null)) {
            ThreadedBinaryTreeNode<T> leftChild = root.getLeft();
            ThreadedBinaryTreeNode<T> rightChild = root.getRight();
            if(leftChild != null) {
                resultNode = getNode(leftChild, data);
            }
            if(rightChild != null) {
                resultNode = getNode(rightChild, data);
            }
            if(root.getData().equals(data)) {
                resultNode = root;
            }
        }
        return resultNode;
    }

    @Override
    public boolean setVal(ThreadedBinaryTreeNode<T> node, T newData) {
        node.setData(newData);
        return true;
    }

    @Override
    public ThreadedBinaryTreeNode<T> getParent(ThreadedBinaryTreeNode<T> childNode) {
        return null;
    }

    @Override
    public ThreadedBinaryTreeNode<T>[] getChildren(ThreadedBinaryTreeNode<T> parentNode) {
        ThreadedBinaryTreeNode<T>[] result = new ThreadedBinaryTreeNode[2];
        ThreadedBinaryTreeNode<T> leftChild = parentNode.getLeft();
        ThreadedBinaryTreeNode<T> rightChild = parentNode.getRight();
        List<ThreadedBinaryTreeNode> list = new ArrayList<>();
        if(leftChild != null) {
            list.add(leftChild);
        }
        if(rightChild != null) {
            list.add(rightChild);
        }
        return list.toArray(result);
    }

    @Override
    public boolean addChild(T childNodeVal, ThreadedBinaryTreeNode<T> parentNode) {
        boolean result = false;
        if(parentNode == null) {
            return result;
        }
        ThreadedBinaryTreeNode<T> node = new ThreadedBinaryTreeNode<T>();
        node.setData(childNodeVal);
        if(parentNode.getLeft() == null) {
            parentNode.setLeft(node);
            result = true;
        } else if(parentNode.getRight() == null) {
            parentNode.setRight(node);
            result = true;
        } else {
            result = false;
        }
        if(result == true) {
            this.size += 1;
        }
        return result;
    }

    @Override
    public boolean removeChild(T childNodeVal, ThreadedBinaryTreeNode<T> parentNode) {
        boolean result = false;
        if(parentNode == null) {
            return result;
        }
        ThreadedBinaryTreeNode<T> leftChild = parentNode.getLeft();
        ThreadedBinaryTreeNode<T> rightChild = parentNode.getRight();
        if(leftChild != null && leftChild.getData().equals(childNodeVal)) {
            parentNode.setLeft(null);
            result = true;
        } else if(rightChild != null && rightChild.getData().equals(childNodeVal)) {
            parentNode.setRight(null);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public void traverse(ThreadedBinaryTreeNode<T> node) {
        if(node != null && node.getLeft() == null && node.getRight() == null) {
            System.out.println("the " + node + " node value: " + node.getStr());
            System.out.println("the " + node + " node left child: " + node.getLeft());
            System.out.println("the " + node + " node right child: " + node.getRight());
            return;
        } else if(node != null && (node.getLeft() != null || node.getRight() != null)) {
            ThreadedBinaryTreeNode<T> leftChild = node.getLeft();
            ThreadedBinaryTreeNode<T> rightChild = node.getRight();
            if(leftChild != null) {
                traverse(leftChild);
            }
            if(rightChild != null) {
                traverse(rightChild);
            }
            System.out.println("the " + node + " node value: " + node.getStr());
            System.out.println("the " + node + " node left child: " + leftChild);
            System.out.println("the " + node + " node right child: " + rightChild);
        } else {
            return;
        }
    }

    @Override
    public void inThreadByInOrder() {
        ThreadedBinaryTreeNode<T> node = this.root;
        if(node != null && node.getLeft() == null && node.getRight() == null) {
            node.setLeftFlag(1);
            node.setLeft(this.preNode);
            return;
        } else if(node != null) {
            ThreadedBinaryTreeNode<T> leftChild = node.getLeft();
            ThreadedBinaryTreeNode<T> rightChild = node.getRight();
            if(leftChild != null) {
                traverse(leftChild);
            } else {
                node.setLeft(this.preNode);
                node.setLeftFlag(1);
            }
            this.preNode = node;
            if(rightChild != null) {
                traverse(rightChild);
            }
        } else {
            return;
        }
    }

}
