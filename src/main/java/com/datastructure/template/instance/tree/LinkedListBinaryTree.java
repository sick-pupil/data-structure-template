package com.datastructure.template.instance.tree;

import com.datastructure.template.element.elementinstance.treenode.LinkedListBinaryTreeNode;
import com.datastructure.template.instanceapi.tree.LinkedListBinaryTreeApi;

import java.util.ArrayList;
import java.util.List;

public class LinkedListBinaryTree<T> implements LinkedListBinaryTreeApi<T> {

    private LinkedListBinaryTreeNode<T> root;

    private int length;

    @Override
    public void init() {
        this.length = 0;
        this.root = new LinkedListBinaryTreeNode<T>();
    }

    @Override
    public boolean isEmpty(LinkedListBinaryTreeNode<T> root) {
        if(root.getLeftChild() != null || root.getRightChild() != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear(LinkedListBinaryTreeNode<T> root) {
        this.length = 0;
        if(root != null && root.getLeftChild() == null && root.getRightChild() == null) {
            root = null;
            return;
        } else if(root != null && (root.getLeftChild() != null || root.getRightChild() != null)) {
            LinkedListBinaryTreeNode<T> leftChild = root.getLeftChild();
            LinkedListBinaryTreeNode<T> rightChild = root.getRightChild();
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
    public LinkedListBinaryTreeNode<T> getRoot() {
        return this.root;
    }

    @Override
    public T valueOf(LinkedListBinaryTreeNode<T> node) {
        return node.getData();
    }

    @Override
    public LinkedListBinaryTreeNode<T> getNode(LinkedListBinaryTreeNode<T> root, T data) {
        LinkedListBinaryTreeNode<T> resultNode = null;
        if(root != null && root.getLeftChild() == null && root.getRightChild() == null) {
            if(root.getData().equals(data)) {
                resultNode = root;
            }
        } else if(root != null && (root.getLeftChild() != null || root.getRightChild() != null)) {
            LinkedListBinaryTreeNode<T> leftChild = root.getLeftChild();
            LinkedListBinaryTreeNode<T> rightChild = root.getRightChild();
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
    public boolean setVal(LinkedListBinaryTreeNode<T> node, T newData) {
        node.setData(newData);
        return true;
    }

    @Override
    public LinkedListBinaryTreeNode<T> getParent(LinkedListBinaryTreeNode<T> childNode) {
        return null;
    }

    @Override
    public LinkedListBinaryTreeNode<T>[] getChildren(LinkedListBinaryTreeNode<T> parentNode) {
        LinkedListBinaryTreeNode<T>[] result = new LinkedListBinaryTreeNode[2];
        LinkedListBinaryTreeNode<T> leftChild = parentNode.getLeftChild();
        LinkedListBinaryTreeNode<T> rightChild = parentNode.getRightChild();
        List<LinkedListBinaryTreeNode> list = new ArrayList<>();
        if(leftChild != null) {
            list.add(leftChild);
        }
        if(rightChild != null) {
            list.add(rightChild);
        }
        return list.toArray(result);
    }

    @Override
    public boolean addChild(T childNodeVal, LinkedListBinaryTreeNode<T> parentNode) {
        boolean result = false;
        if(parentNode == null) {
            return result;
        }
        LinkedListBinaryTreeNode<T> node = new LinkedListBinaryTreeNode<T>();
        node.setData(childNodeVal);
        if(parentNode.getLeftChild() == null) {
            parentNode.setLeftChild(node);
            result = true;
        } else if(parentNode.getRightChild() == null) {
            parentNode.setRightChild(node);
            result = true;
        } else {
            result = false;
        }
        if(result == true) {
            this.length += 1;
        }
        return result;
    }

    @Override
    public boolean removeChild(T childNodeVal, LinkedListBinaryTreeNode<T> parentNode) {
        boolean result = false;
        if(parentNode == null) {
            return result;
        }
        LinkedListBinaryTreeNode<T> leftChild = parentNode.getLeftChild();
        LinkedListBinaryTreeNode<T> rightChild = parentNode.getRightChild();
        if(leftChild != null && leftChild.getData().equals(childNodeVal)) {
            parentNode.setLeftChild(null);
            result = true;
        } else if(rightChild != null && rightChild.getData().equals(childNodeVal)) {
            parentNode.setRightChild(null);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public void traverse(LinkedListBinaryTreeNode<T> node) {
        if(node != null && node.getLeftChild() == null && node.getRightChild() == null) {
            System.out.println("the " + node + " node value: " + node.getStr());
            System.out.println("the " + node + " node left child: " + node.getLeftChild());
            System.out.println("the " + node + " node right child: " + node.getRightChild());
            return;
        } else if(node != null && (node.getLeftChild() != null || node.getRightChild() != null)) {
            LinkedListBinaryTreeNode<T> leftChild = node.getLeftChild();
            LinkedListBinaryTreeNode<T> rightChild = node.getRightChild();
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
}
