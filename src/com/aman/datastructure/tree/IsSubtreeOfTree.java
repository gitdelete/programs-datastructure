package com.aman.datastructure.tree;


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
        *
        *
        */
public class IsSubtreeOfTree {


    public static void main(String[] args) {

//        Node tree = new Node(1);
//        tree.setLeft(new Node(3));
//        tree.setRight(new Node(5));
//        tree.left.left = new Node(10);
//        tree.left.left.right = new Node(13);
//        tree.left.left.right.left = new Node(15);
//        tree.right.left = new Node(7);
//        tree.right.right = new Node(12);
//        tree.right.right.left = new Node(8);
//        tree.right.right.left.left = new Node(10);
//        tree.right.right.left.left.left = new Node(11);
//        tree.right.right.left.left.left.right = new Node(17);
//        tree.right.right.left.left.left.left = new Node(18);
//        tree.right.right.left.left.left.left.left = new Node(20);
//        tree.right.right.left.left.left.left.left.left = new Node(21);
//        tree.right.right.right = new Node(16);
//        tree.right.right.right.right = new Node(19);
//        tree.right.right.right.right.right = new Node(121);


        Node tree = new Node(1);
        tree.left = new Node(12);
        tree.left.left = new Node(8);
        tree.left.left.left = new Node(10);
        tree.left.left.left.left = new Node(11);
        tree.left.left.left.left.right = new Node(17);

        Node sub = new Node(12);
        sub.left = new Node(8);
        sub.left.left = new Node(10);
        sub.left.left.left = new Node(11);
        sub.left.left.left.right = new Node(17);
        boolean check = isSubtree(tree, sub);
        System.out.print(check);
    }


    public static boolean isSubtree(Node tree, Node sub){

        if(tree == null)
            return false;

        if(sub == null)
            return true;

        if(tree.data == sub.data && isSubtree(tree.left, sub.left) && isSubtree(tree.right, sub.right))
            return true;

        return (isSubtree(tree.left, sub) || isSubtree(tree.right, sub));

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
