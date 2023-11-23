package com.aman.datastructure;

import java.util.Arrays;

public class TrieWordSearch {

    TrieNode root;

    static class TrieNode{

        TrieNode[] nodes;
        boolean endOfWord;

        TrieNode(){
            nodes = new TrieNode[26];
            Arrays.fill(nodes,null);
            endOfWord= false;
        }
    }

    public void search(String word){
        if (root == null) {
           System.out.println("Nothing to search !!!");
        }
        TrieNode  node = root;
        int i=0;

        for(i=0; i<word.length();i++) {
            if(node.nodes[word.charAt(i) - 97] != null)
                node = node.nodes[word.charAt(i) - 97];
            else
                break;
        }
        if(i==word.length() && node.endOfWord){
            System.out.println("Word Found !! "+word);
        }else {
            System.out.println("Word not Found !! "+word);
        }
    }

    public void insert(String word){
        if (root == null) {
            root = new TrieNode();
        }
        TrieNode  node = root;
        for(char c : word.toCharArray()) {
            if(node.nodes[c-97] == null) {
                node.nodes[c - 97] = new TrieNode();
            }
            node = node.nodes[c - 97];
        }
        node.endOfWord=true;

    }

    public static void main(String[] args) {

        TrieWordSearch tws = new TrieWordSearch();
        tws.insert("aman");
        tws.search("aman");


    }
}
