package com.aman.datastructure.tree;

import java.util.*;


/*              1
 *           3     5
 *        10    7    12
 *          13     8   16
 *        15     10          19
 *           11                  121
 *        18
 *      20
 *    21
 *
 *   1   3  10  5  12  20  21  16  19  121  // not in order though  (for printing
 *                                              order left to right , take a leftList and
 *                                              rightList then print seperately)
 *
 */
public class TopViewTree {

    private static int maxLeft=1;
    private static int maxRight=1;
    public static void main(String[] args) {

        Node1 root = new Node1(1);
        root.setLeft(new Node1(3));
        root.setRight(new Node1(5));
        root.left.left = new Node1(10);
        root.left.left.right = new Node1(13);
        root.left.left.right.left = new Node1(15);
        root.right.left = new Node1(7);
        root.right.right = new Node1(12);
        root.right.right.left = new Node1(8);
        root.right.right.left.left = new Node1(10);
        root.right.right.left.left.left = new Node1(11);
        root.right.right.left.left.left.left = new Node1(18);
        root.right.right.left.left.left.left.left = new Node1(20);
        root.right.right.left.left.left.left.left.left = new Node1(21);
        root.right.right.right = new Node1(16);
        root.right.right.right.right = new Node1(19);
        root.right.right.right.right.right = new Node1(121);

        //printTopViewWithoutRecursion(root);

        System.out.println("\nprintTopViewWithRecursion !!!!! ");
        int leftLevel = 1;
        int rightLevel = 1;
        System.out.print(root.data+"   ");
        printTopViewWithRecursion(root, leftLevel, rightLevel);

    }

    private static void printTopViewWithRecursion(Node1 root,int leftLevel,int rightLevel) {

        if(root == null){
            return;
        }

        if(leftLevel>maxLeft){
            System.out.print(root.data+"  ");
            maxLeft=leftLevel;
        }

        if(rightLevel>maxRight){
            System.out.print(root.data+"  ");
            maxRight=rightLevel;
        }
        printTopViewWithRecursion(root.left, leftLevel+1, rightLevel-1);
        printTopViewWithRecursion(root.right, leftLevel-1, rightLevel+1);
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

