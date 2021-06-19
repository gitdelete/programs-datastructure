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
 *   h = 9
 *
 */
public class HeightOfTree {

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

        int h = heightOfTree(root);
        System.out.println(h);

    }


    private static int heightOfTree(Node node) {

        if(node == null){
            return 0;
        }

        int left=heightOfTree(node.left);
        int right=heightOfTree(node.right);

        return Math.max(left,right)+1;

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
