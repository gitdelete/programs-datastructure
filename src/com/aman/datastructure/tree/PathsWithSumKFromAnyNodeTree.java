package com.aman.datastructure.tree;

//*
//
//                              1
//                     3                   5
//               9                  7          12
//                     13                   8
//               15                     10
//           -15                    11
//
//
//*/

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class PathsWithSumKFromAnyNodeTree {


    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeft(new Node(3));
        root.setRight(new Node(5));
        root.left.left = new Node(9);
        root.left.left.right = new Node(13);
        root.left.left.right.left = new Node(15);
        root.left.left.right.left.left = new Node(-15);
        root.right.left = new Node(7);
        root.right.right = new Node(12);
        root.right.right.left = new Node(8);
        root.right.right.left.left = new Node(10);
        root.right.right.left.left.left = new Node(11);

        int sum = 13;
        int result = 0;
        List<List<Node>> paths = new ArrayList<>();
        List<Node> path = new ArrayList<Node>();
        findPathsWithSum(root, sum, result, paths, path);

        for (List<Node> list : paths){
            for (Node n : list){
                System.out.print(n.data+" ");
            }
            System.out.println("");
        }

    }


    /* Finds all paths with sum k and return all paths */
    private static void findPathsWithSum(Node node, int sum, int result, List<List<Node>> paths, List<Node> path) {
        if(node == null){
            return;
        }

        result = result+ node.data;
        path.add(node);

        if(sum == result){
//            System.out.println(path);
            List<Node> list = new ArrayList<>(path);
            paths.add(list);
//            return;
        }

        findPathsWithSum(node.left, sum, result, paths, path);
        findPathsWithSum(node.right, sum, result, paths, path);
        path.remove(node);
        return;
    }

    /* Finds first path with sum k and returns */
    private static boolean findSinglePathWithSum(Node node, int sum, int result, List<List<Node>> paths, List<Node> path) {

        if(sum == result){
            System.out.println(path);
            List<Node> list = new ArrayList<>(path);
            paths.add(list);
            return true;
        }
        if(node == null){
            return false;
        }
        result = result+ node.data;
        path.add(node);
        if(findSinglePathWithSum(node.left, sum, result, paths, path)){
            return true;
        }
        if(findSinglePathWithSum(node.right, sum, result, paths, path)){
            return true;
        }
        path.remove(node);
        return false;
    }

    /* Another way to print all the paths with sum k */
    static Vector<Integer> path1 = new Vector<Integer>();
    static void printKPathUtil(Node root, int k)
    {
        // empty node
        if (root == null)
            return;

        // add current node to the path
        path1.add(root.data);

        // check if there's any k sum path
        // in the left sub-tree.
        printKPathUtil(root.left, k);

        // check if there's any k sum path
        // in the right sub-tree.
        printKPathUtil(root.right, k);

        // check if there's any k sum path that
        // terminates at this node
        // Traverse the entire path as
        // there can be negative elements too
        int f = 0;
        for (int j = path1.size() - 1; j >= 0; j--) {
            f += path1.get(j);

            // If path sum is k, print the path
            if (f == k)
                printVector(path1, j);
        }

        // Remove the current element from the path
        path1.remove(path1.size() - 1);
    }

    static void printVector(Vector<Integer> v, int i)
    {
        for (int j = i; j < v.size(); j++)
            System.out.print(v.get(j) + " ");
        System.out.println();
    }


    static class Node {

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
