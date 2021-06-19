package com.aman.datastructure.tree;

import java.util.ArrayList;
import java.util.List;


/*             1
 *           3     5
 *        10    7    12
 *          13     8   16
 *        15     10          19
 *           11                  121
 *        18
 *      20
 *    21
 *
 *   data = 19
 *   Result = 1  5  12  16  19
 *
 *   data = 11
 *   Result = 1  5  12  8  10  11
 */
public class PathOfNodeTree {


    public static void main(String[] args) {

        Node root = new Node(1);
        root.setLeft(new Node(3));
        root.setRight(new Node(5));
        root.left.left = new Node(10);
        root.left.left.right = new Node(13);
        root.left.left.right.left = new Node(15);
        root.right.left = new Node(7);
        root.right.right = new Node(12);
        root.right.right.left = new Node(8);
        root.right.right.left.left = new Node(10);
        root.right.right.left.left.left = new Node(11);
        root.right.right.left.left.left.left = new Node(18);
        root.right.right.left.left.left.left.left = new Node(20);
        root.right.right.left.left.left.left.left.left = new Node(21);
        root.right.right.right = new Node(16);
        root.right.right.right.right = new Node(19);
        root.right.right.right.right.right = new Node(121);

        List<Node> ar = new ArrayList<>();

        int data1 = 19;
        System.out.println("\nPath to Node !!! "+ data1);
        printPathOfNode(root, ar, data1);
        ar.stream().forEach(a-> System.out.print(a.data+ "  "));

        ar = new ArrayList<>();
        int data2 = 11;
        System.out.println("\nPath to Node !!! "+ data2);
        printPathOfNode(root, ar, data2);
        ar.stream().forEach(a-> System.out.print(a.data+ "  "));


    }


    public static  boolean printPathOfNode(Node node, List<Node> nodesList, int data){

        if(node == null){
            return false;
        }

        nodesList.add(node);

        if(data == node.data)
            return true;


        if(printPathOfNode(node.left, nodesList, data)){
            return true;
        }
        if(printPathOfNode(node.right, nodesList, data)){
            return true;
        }

        nodesList.remove(node);
        return false;
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
