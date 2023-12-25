package com.aman.datastructure.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;


/*
*  https://hellokoding.com/detect-cycle-in-a-directed-graph/
*  https://itecnote.com/tecnote/c-detecting-cycle-in-an-undirected-graph-using-iterative-dfs/
* */
public class DetectCycleDirectedByDFSIterative {

    LinkedList<Node>[] nodes ;
    int vertices;

    public DetectCycleDirectedByDFSIterative(int vertices) {
        this.vertices = vertices;
        nodes = new LinkedList[vertices];
        //initialize adjacency lists for all the vertices
        for (int i = 0; i <vertices ; i++) {
            nodes[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int w, int d){
        Node node = new Node(s,w,d);
        nodes[s].add(node);
    }

    public  boolean dfsByIterative() {
        boolean[] visited = new boolean[vertices];
        boolean[] onStack = new boolean[vertices];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < vertices; i++) {
            if (visited[i])
                continue;
            stack.push(i);

            while (!stack.isEmpty()) {
                int v = stack.peek();

                if (!visited[v]) {
                    visited[v] = true;
                    onStack[v] = true;
                } else {
                    onStack[v] = false;
                    stack.pop();
                }

                for (Node w : nodes[v]) {
                    if (!visited[w.dest]) {
                        stack.push(w.dest);
                    } else if (onStack[w.dest]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DetectCycleDirectedByDFSIterative g1 = new DetectCycleDirectedByDFSIterative(5);
        g1.addEdge(0, 0,1);
        g1.addEdge(1, 0,2);
        g1.addEdge(2, 0,3);
        g1.addEdge(1, 0,4);
        g1.addEdge(2, 0,4);
        g1.addEdge(4, 0,0);
        System.out.println(g1.dfsByIterative());

    }

    private class Node {
        int source;
        int weight;
        int dest;

        Node(int source, int weight, int dest) {
            this.source = source;
            this.weight = weight;
            this.dest = dest;
        }
    }
}