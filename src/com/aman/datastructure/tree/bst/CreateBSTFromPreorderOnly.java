package com.aman.datastructure.tree.bst;

public class CreateBSTFromPreorderOnly {
    public static void main(String[] args) {
        int[] preorder = {15, 10, 8, 12, 20, 16, 25};
        Node root = constructBST(preorder, 0, preorder.length - 1);

        System.out.print("Inorder traversal of BST is ");
        inorder(root);
    }

    public static Node constructBST(int[] preorder, int start, int end) {
        // base case
        if (start > end) {
            return null;
        }

        Node node = new Node(preorder[start]);

        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > node.key) {
                break;
            }
        }

        node.left = constructBST(preorder, start + 1, i - 1);
        node.right = constructBST(preorder, i, end);

        return node;
    }

    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }


    static class Node
    {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

}

