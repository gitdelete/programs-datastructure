package com.aman.datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
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
 *      Longest Path to Leaf in Tree !!!
        21  20  18  11  10  8  12  5  1
 */
public class LongestPathInTree {


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

        List<Node> ar ;

        System.out.println("\nLongest Path to Leaf in Tree !!! ");
        ar= longestPath(root);

        ar.stream().forEach(a-> System.out.print(a.data+"  "));

        allPathsToLeaf(root, new int[1000], 0);

    }


    public static void allPathsToLeaf(Node root, int[] path,int count)
    {
        if(root == null)
        {
            return;
        }

        path[count] = root.data;
        if(root.left == null && root.right ==null){
            System.out.println("");
            for (int i=0; i<=count; i++)
                System.out.print(path[i]+"  ");
        }


         allPathsToLeaf(root.right, path, count+1);
         allPathsToLeaf(root.left, path, count+1);

    }

    private static void printPath(int[] path) {
        Arrays.stream(path);
    }

    public static ArrayList<Node> longestPath(Node root)
    {
        if(root == null)
        {
            ArrayList<Node> arr = new ArrayList<>();
            return arr;
        }

        ArrayList<Node> right = longestPath(root.right);
        ArrayList<Node> left = longestPath(root.left);

        if(right.size() < left.size())
        {
            left.add(root);
        }
        else
        {
            right.add(root);
        }

        return (left.size() >
                right.size() ? left :right);
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
