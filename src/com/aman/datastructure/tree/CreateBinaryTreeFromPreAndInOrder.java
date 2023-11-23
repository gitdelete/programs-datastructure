package com.aman.datastructure.tree;

public class CreateBinaryTreeFromPreAndInOrder {

    static int index=0;

    public static void main(String[] args) {

        int[] preOrder = {1,3,10,13,15,5,7,12,8,10,11,18,20,21,16,19,121};
        int[] inOrder = {10,15,13,3,1,7,5,21,20,18,11,10,8,12,16,19,121};

//        Node node = new Node(preOrder[0]);
        Node node=createBinaryTree(preOrder, inOrder, 0, preOrder.length-1);
        printPostOrder(node);
    }

    private static Node createBinaryTree(int[] preOrder, int[] inOrder, int start, int end) {

        if (start > end)
            return null;
        int data = preOrder[index];
        Node tNode = new Node(data);
        index++;

        if (start == end)
            return tNode;

        int inOrderIndex = search (inOrder, data, start,end);
        if(inOrderIndex == -1){
            System.out.println("Something wrong !!");
            System.exit(1);
        }
        tNode.left=createBinaryTree(preOrder, inOrder, start, inOrderIndex -1 );
        tNode.right=createBinaryTree(preOrder, inOrder, inOrderIndex+1, end );
        return tNode;
    }

    private static int search(int[] inOrder, int data, int start, int end) {

        for(int i=start; i<=end; i++){
            if(inOrder[i]==data){
                return i;
            }
        }
        return -1;
    }

    static void printPostOrder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printPostOrder(node.left);
        /* now recur on right child */
        printPostOrder(node.right);
        /* then print the data of node */
        System.out.print(node.data + " ");
    }


    public static class Node<T extends Integer> {

        private T data;
        private Node left, right;

        public Node(T data){
            this.data = data;
            left = right = null;
        }

        public T getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
