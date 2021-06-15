package com.aman.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*              1
   *            3     5
   *         10     7   12
   *           13
   *       15
   *
   *       Pre Order !!!!
           10  15  13  3  1  7  5  12
           In Order !!!
           10  15  13  3  1  7  5  12
           Post Order
           15  13  10  3  7  12  5  1
   */
public class TraversingTree {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.setLeft(new Node(3));
        root.setRight(new Node(5));
        root.left.left = new Node(10);
        root.left.left.right = new Node(13);
        root.left.left.right.left = new Node(15);
        root.right.left = new Node(7);
        root.right.right = new Node(12);

        System.out.println("Pre Order !!!!");
        preOrderTraversal(root);

        System.out.println("\nIn Order !!!");
        inOrderTraversal(root);

        System.out.println("\nPost Order !!!");
        postOrderTraversal(root);


        System.out.println("\npreOrderTraversalNonRecursive !!!!");
        preOrderTraversalNonRecursive(root);

        System.out.println("\ninOrderTraversalNonRecursive !!!!");
        inOrderTraversalNonRecursive(root);

        System.out.println("\npostOrderTraversalNonRecursive !!!!");
        postOrderTraversalNonRecursive(root);

    }

    private static void preOrderTraversalNonRecursive(Node root) {

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.data+"  " );

            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }

    private static void inOrderTraversalNonRecursive(Node root) {

        Stack<Node> stack = new Stack<>();

        Node node =  root;
        while(!stack.isEmpty() || node != null){

            while(node != null){
                stack.push(node);
                node= node.left;
            }
            node = stack.pop();
            System.out.print(node.data+"  " );
            node = node.right;

        }
    }

    private static void postOrderTraversalNonRecursive(Node root) {

        Stack<Node> stack = new Stack<>();

        Node node =  root;
        stack.push(node);
        while(!stack.isEmpty() ){

            while(node != null) {
                stack.push(node);
                node = node.right;
            }
            node= node.left;


        }
    }

    private static void inOrderTraversal(Node root) {
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+ "  ");
        inOrderTraversal(root.right);
    }

    private static void preOrderTraversal(Node root) {
        if(root == null){
            return;
        }
        System.out.print(root.data+ "  ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void postOrderTraversal(Node root) {
        if(root == null){
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+ "  ");
    }

    static class Node{
        private int data;
        private Node left;
        private Node right;
        public Node(int data){
            this.data=data;
            left = right = null;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}


