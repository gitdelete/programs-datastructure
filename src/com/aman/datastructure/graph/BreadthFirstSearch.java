package com.aman.datastructure.graph;

import com.sun.source.tree.WhileLoopTree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    LinkedList<Node>[] nodes ;
    int vertices;
    public BreadthFirstSearch(int vertices) {
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

    // Directed Graph
    public void bfs(int start){

        boolean[] visited = new boolean[nodes.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()){
            int x=queue.remove();
            if(visited[x]==false) {
                visited[x] = true;
                System.out.print(x + " ");
            }
            for(int i=nodes[x].size()-1; i>=0; i--){
                if(!visited[nodes[x].get(i).dest]){
                    queue.add(nodes[x].get(i).dest);
                }
            }
        }
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            LinkedList<Node> list = nodes[i];
            System.out.print("vertex-" + i + " is connected to " );
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j).dest+" ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch graph = new BreadthFirstSearch(4);
        graph.addEdge(0, 0, 1);
        graph.addEdge(0, 0, 2);
        graph.addEdge(1, 0, 2);
        graph.addEdge(2, 0, 0);
        graph.addEdge(2, 0, 3);
        graph.addEdge(3, 0, 0);

        graph.printGraph();
        graph.bfs(2);

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

