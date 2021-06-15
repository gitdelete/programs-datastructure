package com.aman.datastructure.tree.bst;

import java.math.BigDecimal;

public class BinarySearchTreeMain {

    public static void main(String[] args) {
        BinarySearchTreeCustom<Integer> bst = new BinarySearchTreeCustom<Integer>();

        // Adding nodes to construct BST
        System.out.println("\nConstructing BST !!!");
        bst.add(10); bst.add(20); bst.add(8);
        bst.add(30); bst.add(11); bst.add(17);
        bst.add(4); bst.add(6); bst.add(5);
        bst.add(9); bst.add(22); bst.add(27);
        bst.add(1); bst.add(25);

        // Traversing Inorder after constructing BST
        System.out.println("\nTraversing BST !!!");
        bst.traverseInorder();      // Inorder prints sorted ascending order for BST

        //Searching BST
        System.out.println("\nSearching BST !!!!");
        bst.find(23);
        bst.find(10);
        bst.find(9);
        bst.find(27);
    }
}
