package com.aman.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*                  1
 *            3     5
 *         10     7   12
 *           13          16
 *       15                  19
 *                               121
 *
 *
 */
public class LeftViewTree {

    private static int maxLevel;

    public static void main(String[] args) {

        Node1 root = new Node1(1);
        root.setLeft(new Node1(3));
        root.setRight(new Node1(5));
        root.left.left = new Node1(10);
        root.left.left.right = new Node1(13);
        root.left.left.right.left = new Node1(15);
        root.right.left = new Node1(7);
        root.right.right = new Node1(12);
        root.right.right.right = new Node1(16);
        root.right.right.right.right = new Node1(19);
        root.right.right.right.right.right = new Node1(121);

        System.out.println("printLeftViewWithoutRecursion !!!");
        printLeftView(root);

        int level=1;


        System.out.println("printLeftViewWithRecursion !!!");
        printLeftViewWithRecursion(root, level);

    }

    private static void printLeftViewWithRecursion(Node1 root, int level) {

        if(root == null){
            return;
        }

        if(maxLevel<level){
            System.out.println(root.data);
            maxLevel=level;
        }

        printLeftViewWithRecursion(root.left, level+1);
        printLeftViewWithRecursion(root.right, level+1);
    }

    private static void printLeftView(Node1 root) {

        if (root == null){
            return;
        }
        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);

        while(! queue.isEmpty()){
            int n= queue.size();
            for(int i=1;i<=n;i++){
                Node1 node = queue.poll();
                if(i==1){
                    System.out.println(node.data);
                }
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);

            }

        }


    }



    static class Node1{
        private int data;
        private Node1 left;
        private Node1 right;
        public Node1(int data){
            this.data=data;
            left = right = null;
        }

        public void setLeft(Node1 left) {
            this.left = left;
        }

        public void setRight(Node1 right) {
            this.right = right;
        }
    }
}
