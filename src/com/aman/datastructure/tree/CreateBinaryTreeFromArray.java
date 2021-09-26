package com.aman.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CreateBinaryTreeFromArray {

    public static void main(String[] args) {

        int[] arr = {3,43,12,23,5,19,17,34,67,1,10,25};
        Node node= new Node(arr[0]);

        System.out.println("Without Recursion");
        Node root=createBinaryTreeWithoutRecursion(arr);
        printPreOrder(root);

        System.out.println(" ");
        System.out.println("With Recursion");
        Node root1=createBinaryTree(node,arr, 0);
        printPreOrder(root1);

    }

    private static Node createBinaryTree(Node node, int[] arr, int index) {
        if (index < arr.length) {
            Node temp = new Node(arr[index]);
            node = temp;

            // insert left child
            node.left = createBinaryTree( node.left,arr,
                    2 * index + 1);

            // insert right child
            node.right = createBinaryTree(node.right,arr,
                    2 * index + 2);
        }
        return node;

    }

    private static Node createBinaryTreeWithoutRecursion(int[] arr) {

        Node node=new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> queueIndex = new LinkedList<>();
        queue.add(node);
        queueIndex.add(0);

        int half = (arr.length-1)/2;
        for (int i=0; i<=half; i++) {
            int size = queue.size();
            while (size > 0) {
                Node n = queue.peek();
                if(((2*queueIndex.peek())+1)<arr.length) {
                    n.left = new Node(arr[(2 * queueIndex.peek()) + 1]);
                    queue.add(n.left);
                    queueIndex.add((2 * queueIndex.peek()) + 1);
                }
                if(((2*queueIndex.peek())+2)<arr.length) {
                    n.right = new Node(arr[(2 * queueIndex.peek()) + 2]);
                    queue.add(n.right);
                    queueIndex.add((2 * queueIndex.peek()) + 2);
                }
                queue.poll();
                queueIndex.poll();
                size--;
            }

        }
        return node;
    }

    private static void printPreOrder(Node root) {

        if(root!=null) {
            System.out.print(root.data+ "  ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }

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
