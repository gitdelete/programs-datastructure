package com.aman.datastructure.tree.bst;

import com.aman.datastructure.tree.TraversingTree;

import java.util.Stack;

public class BinarySearchTreeCustom<T extends Integer> {

    Node<T> root = null;
    public BinarySearchTreeCustom(){

    }

    public boolean find(T data){
        Node<T> node = root;
        while (true){
            while (data < node.getData()) {
                if (node.getLeft() == null) {
                    break;
                }
                node = node.getLeft();
            }
            while (data > (T) node.getData()) {
                if (node.getRight() == null) {
                    break;
                }
                node = node.getRight();
            }
            if(node.getRight() == null && node.getRight() == null){
                System.out.println("Data Not Found !!! Get Lost !!!  "+ data);
                break;
            }
            if(data == node.getData()){
                System.out.println("Found Data !!!!  "+ data);
                return true;
            }
        }
        return false;
    }

    public void add(T data) {
        System.out.println("Adding Node - "+data);
        if (root == null) {
            root = new Node<T>(data);
            return;
        }
        Node<T> node = root;
        boolean flag = true;
        while (flag){
            while (data < node.getData()) {
                if (node.getLeft() == null) {
                    break;
                }
                node = node.getLeft();
            }
            while (data > node.getData()) {
                if (node.getRight() == null) {
                    break;
                }
                node = node.getRight();
            }
            if(data<node.getData() && node.getLeft() == null){
                node.setLeft(new Node<T>(data));
                flag=false;
            }
            if(data> node.getData() && node.getRight() == null){
                node.setRight(new Node<T>(data));
                flag=false;
            }
        }
    }

    public void remove(T data){


    }

    public void traverseInorder() {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> node =  root;

        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node= node.getLeft();
            }
            node = stack.pop();
            System.out.print(node.getData()+"  " );
            node = node.getRight();
        }
    }
}
