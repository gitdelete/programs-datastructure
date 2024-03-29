package com.aman.datastructure.graph;

import com.sun.source.tree.WhileLoopTree;

import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch {

    LinkedList<Node>[] nodes ;
    int vertices;
    public DepthFirstSearch(int vertices) {
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
    public void dfs(int start){
        boolean[] visited = new boolean[nodes.length];
        Stack<Integer> st = new Stack<>();
        st.push(start);

        while (!st.empty()){
            int x=st.pop();

            if(visited[x] == false) {
                System.out.print(x + " ");
                visited[x] = true;
            }
            for(int i=nodes[x].size()-1; i>=0; i--){
                if(!visited[nodes[x].get(i).dest]){
                    st.push(nodes[x].get(i).dest);
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
        DepthFirstSearch graph = new DepthFirstSearch(8);
        graph.addEdge(0, 0, 1);
        graph.addEdge(0, 0, 2);
        graph.addEdge(0, 0, 3);
        graph.addEdge(1, 0, 2);
        graph.addEdge(1, 0, 3);
        graph.addEdge(2, 0, 3);
        graph.addEdge(3, 0, 4);
//        graph.addEdge(5, 0, 0);
        graph.addEdge(4, 0, 1);
        graph.addEdge(5, 0, 6);
        graph.addEdge(4, 0, 5);
        graph.addEdge(6, 0, 7);

        graph.printGraph();
        graph.dfs(0);

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

