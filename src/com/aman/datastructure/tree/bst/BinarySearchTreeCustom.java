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

    public Node findWithRecursion(int data){

        Node n = findWithRec(root, data, true);
        return null;
    }

    private Node findWithRec(Node node, int data, boolean flag) {

        if(node == null)
            return null;
        if(data == node.getData()){
           System.out.println(data);
            flag = false;
            return node;
        }
        if(flag) {
            findWithRec(node.getLeft(), data, true);

            findWithRec(node.getRight(), data, true);
        }
        return null;
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
        // find and traverse to reduce time complexity
        Node[] nodes = findAndTraverseInorder(data);
        Node foundNode = nodes[1];
        Node preNode = nodes[0];
        if(nodes[1] == null){
            System.out.println("No node found to delete !!!!");
        }
        if(nodes[1].getLeft() == null && nodes[1].getRight() == null){
            if(nodes[1].getData() < nodes[0].getData())
            nodes[0].setLeft(null);
            else
            nodes[0].setRight(null);
            System.out.println("Removed Leaf node  !!");
        }

        if(nodes[1].getLeft() == null && nodes[1].getRight() != null){
            nodes[0].setRight(nodes[1].getRight());
            System.out.println("Removed node with 1 child node  !!");
        }
        if(nodes[1].getLeft() != null && nodes[1].getRight() == null){
            nodes[0].setLeft(nodes[1].getLeft());
            System.out.println("Removed node with 1 child node  !!");
        }

        if(nodes[1].getLeft() != null && nodes[1].getRight() != null){
            System.out.println("Hold On !! In progress !!");
        }

    }

    public void traverseInorder() {
        Node<T> prev = root;
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

    public Node[] findAndTraverseInorder(int data) {
        Node<T> preNode = null;
        Node<T> foundNode= null;
        Stack<Node<T>> stack = new Stack<>();
        Node<T> node =  root;
        Node[] nodes = new Node[2];

        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node= node.getLeft();
            }

            node = stack.pop();
            if(data == node.getData())
            {
                nodes[0] = stack.peek();
                nodes[1] = node;
                return nodes;
            }
//            System.out.print(node.getData()+"  " );
            node = node.getRight();
        }

        return nodes;
    }
}
