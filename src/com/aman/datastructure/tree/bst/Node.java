package com.aman.datastructure.tree.bst;

public class Node<T extends Integer> {

    private T data;
    private Node left, right;

    public Node(T data){
        this.data = data;
        left = right = null;
    }

    public T getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
