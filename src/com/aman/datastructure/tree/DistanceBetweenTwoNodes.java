package com.aman.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class DistanceBetweenTwoNodes {


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

        printPreOrder(root);
        printPathOfNode(root);
        findDistance(root, 13,18);
        findDistance(root, 16,121);

    }

    private static void findDistance(Node root, int i, int j) {


        List<Node> firstPath= new ArrayList<>();
        findNodePath(root,i,firstPath);
        System.out.println(" ");
        for (Node x: firstPath
             ) {
            System.out.print(x.data+" ");

        }
        System.out.println(" ");

        List<Node> secondPath= new ArrayList<>();
        findNodePath(root,j, secondPath);

        for (Node x: secondPath
        ) {
            System.out.print(x.data+" ");
        }

        System.out.println(" ");


        if (firstPath.size()==0 || secondPath.size() == 0){
            System.out.println("There is no distance from node first to second !!!");
        }

        int indexFirstNode =-1;
        int indexSecondNode =-1;
        for (int m=firstPath.size()-1; m>=0; m--) {
            if(secondPath.contains(firstPath.get(m))){
                indexSecondNode = secondPath.indexOf(firstPath.get(m));
                indexFirstNode = m;
                break;
            }
        }

        if(indexFirstNode != -1) {
            for (int m = firstPath.size() - 1; m >= indexFirstNode; m--) {
                System.out.print(firstPath.get(m).data + " ");
            }

            for (int m = indexSecondNode+1; m < secondPath.size(); m++) {
                System.out.print(secondPath.get(m).data + " ");
            }
        }
    }

    private static boolean findNodePath(Node node, int i, List<Node> path) {

        if(node == null)
            return false;

        path.add(node);

        if(node.data == i)
            return true;

        if(findNodePath(node.left,i,path))
            return true;
        if (findNodePath(node.right,i,path))
            return true;

        path.remove(node);
        return false;
    }

    private static void printPreOrder(Node root) {

        if(root != null){
            System.out.print(root.data+ "  ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }

    }


    public static void printPathOfNode(Node node){



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
