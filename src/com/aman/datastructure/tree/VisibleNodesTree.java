package com.aman.datastructure.tree;


/*             1
 *           3     5
 *        10    7    12
 *          13     8   16
 *        15     10        19
 *             11              121
 *           18
 *         20
 *        21
 *
 *
 */
public class VisibleNodesTree {


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

        /*  Node root = new Node(8);
          root.setLeft(new Node(2));
          root.setRight(new Node(6));
            root.left.left = new Node(8);
        root.left.right = new Node(7);*/

        System.out.println("\n All Path to Leaf in Tree !!! ");
        allPathsToLeaf(root, root.data);
        System.out.println(count);

    }

    static int count = 0;
    public static void allPathsToLeaf(Node root, int largest)
    {
        if(root == null)
        {
            return;
        }
        System.out.println(largest + " " + root.data);
        if(largest <= root.data){

            largest = root.data;
            System.out.println(largest);
            count++;
        }


        allPathsToLeaf(root.right, largest);
        allPathsToLeaf(root.left, largest);

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
