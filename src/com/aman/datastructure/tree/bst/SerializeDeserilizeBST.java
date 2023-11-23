package com.aman.datastructure.tree.bst;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class SerializeDeserilizeBST {


    //ArrayList to store serialized tree instead of file. We can write to file as well.
    private static ArrayList<Integer> nodesList = new ArrayList<>();

    public static void serializeBST(Node root){

        if(root == null) {
            System.out.print(null +" ");
            nodesList.add(-1);
        }
        else {
            System.out.print(root.getData()+" ");
            nodesList.add(root.getData());
        }
        if(root != null){
            serializeBST(root.getLeft());
            serializeBST(root.getRight());
        }


    }

    public static void deserializeBST(){

        Node node = new Node(nodesList.get(0));
        Node root= node;
        nodesList.remove(nodesList.get(0));
        Iterator<Integer> itr = nodesList.iterator();
        while (itr.hasNext()){
            Node n = null;
            int data = itr.next();
            if(data == -1){
                n=null;
            }else {
                boolean flag = true;
                while (flag) {
                    while (data < node.getData()) {
                        if (node.getLeft() == null) {
                            break;
                        }
                        node = node.getLeft();
                    }
                    while (data > node.getData()) {
                        if (node.getRight() == null) {
                            break;
                        }
                        node = node.getRight();
                    }
                    if (data < node.getData() && node.getLeft() == null) {
                        node.setLeft(new Node(data));
                        flag = false;
                    }
                    if (data > node.getData() && node.getRight() == null) {
                        node.setRight(new Node(data));
                        flag = false;
                    }
                }
            }
        }

        preOrderTraversal(root);
    }

    private static void preOrderTraversal(Node root) {
        if(root != null){
            System.out.print(root.getData()+"  ");
            inorderTraversal(root.getLeft());
            inorderTraversal(root.getRight());
        }
    }


    public static void inorderTraversal(Node root){

        if(root != null){
            inorderTraversal(root.getLeft());
            System.out.print(root.getData()+"  ");
            inorderTraversal(root.getRight());
        }

    }

    public static void main(String[] args) {
        Node root= new Node(50);
        root.setLeft(new Node(40));
        root.setRight(new Node(60));
        root.getLeft().setLeft(new Node(30));
        root.getLeft().getLeft().setRight(new Node(35));
        root.setRight(new Node(60));
        root.getRight().setLeft(new Node(55));
        root.getRight().setRight(new Node(70));
        root.getRight().getRight().setRight(new Node(72));
        preOrderTraversal(root);

        System.out.println(" ");
        serializeBST(root);

        deserializeBST();

    }

}
