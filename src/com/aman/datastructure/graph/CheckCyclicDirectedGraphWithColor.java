package com.aman.datastructure.graph;

import java.util.*;

public class CheckCyclicDirectedGraphWithColor {

    LinkedList<Node>[] nodes ;
    int vertices;
    public CheckCyclicDirectedGraphWithColor(int vertices) {
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
    public void detectCycleDFS(int start){
        int WHITE = 0;// not visited
        int GRAY=1;  // currently in loop
        int BLACK=2; // processed and no cycle
        int[] color = new int[nodes.length];
        Arrays.fill(color, WHITE);
        Stack<Integer> st = new Stack<>();
        st.push(start);
        while (!st.empty()){
            int x=st.pop();
            color[x] = GRAY;
            boolean isWhite = false;
            for(int i=nodes[x].size()-1; i>=0; i--){
                if(color[nodes[x].get(i).dest] == WHITE){
                    st.push(nodes[x].get(i).dest);
                    isWhite =true;
                }
                if(color[nodes[x].get(i).dest] == GRAY){
                    System.out.println("Cycle Detected at "+ nodes[x].get(i).dest);
                    return;
                }
            }
            if (!isWhite){

            }
        }
    }

    private void printCycle(List<Integer> listCycle, int node) {

        for (int i=listCycle.indexOf(Integer.valueOf(node)); i<listCycle.size(); i++){
            System.out.print(listCycle.get(i)+" ");
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
        CheckCyclicDirectedGraphWithColor graph = new CheckCyclicDirectedGraphWithColor(8);
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
        graph.detectCycleDFS(0);

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

