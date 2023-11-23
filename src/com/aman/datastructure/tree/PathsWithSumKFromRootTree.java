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

public class PathsWithSumKFromRootTree {


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

        int sum = 26;
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
            List<Node> list = new ArrayList<>(path);
            paths.add(list);
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
    static void printPathsUtil(Node curr_node, int sum,
                               int sum_so_far,
                               ArrayList<Integer> path)
    {
        if (curr_node == null)
            return;

        // Add the current node's value
        sum_so_far += curr_node.data;

        // Add the value to path
        path.add(curr_node.data);

        // Print the required path
        if (sum_so_far == sum)
        {
            System.out.print("Path found: ");
            for(int i = 0; i < path.size(); i++)
                System.out.print(path.get(i) + " ");

            System.out.println();
        }

        // If left child exists
        if (curr_node.left != null)
            printPathsUtil(curr_node.left, sum,
                    sum_so_far, path);

        // If right child exists
        if (curr_node.right != null)
            printPathsUtil(curr_node.right, sum,
                    sum_so_far, path);

        // Remove last element from path
        // and move back to parent
        path.remove(path.size() - 1);
    }

    // Wrapper over printPathsUtil
    static void printPaths(Node root, int sum)
    {
        ArrayList<Integer> path = new ArrayList<>();
        printPathsUtil(root, sum, 0, path);
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
