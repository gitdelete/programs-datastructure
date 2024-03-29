package com.aman.datastructure.graph;

import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CheckCyclicDirectedGraph {

    LinkedList<Node>[] nodes ;
    int vertices;
    public CheckCyclicDirectedGraph(int vertices) {
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
        boolean[] visited = new boolean[nodes.length];
        Stack<Integer> st = new Stack<>();
        st.push(start);
        List<Integer> listCycle = new ArrayList<>();
        boolean flagAdded = true;
        int node;
        boolean peek = true;
        while (!st.empty()){

            if (!flagAdded){
                node=st.pop();
                listCycle.remove(Integer.valueOf(node));
            }else {
                node = st.peek();
                listCycle.add(node);
            }
            flagAdded=false;
            visited[node] = true;
            for(int i=nodes[node].size()-1; i>=0; i--){
                if(!visited[nodes[node].get(i).dest]){
                    st.push(nodes[node].get(i).dest);
                    flagAdded =true;
                }
                if(listCycle.contains(nodes[node].get(i).dest) && flagAdded){
                    System.out.println("Cycle Found !!!");
                    printCycle(listCycle, nodes[node].get(i).dest);

                }
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
        CheckCyclicDirectedGraph graph = new CheckCyclicDirectedGraph(10);
        graph.addEdge(0, 0, 1);
        graph.addEdge(0, 0, 2);
        graph.addEdge(0, 0, 3);
        graph.addEdge(1, 0, 2);
        graph.addEdge(1, 0, 3);
        graph.addEdge(1, 0, 8);
        graph.addEdge(2, 0, 3);
        graph.addEdge(3, 0, 4);
//        graph.addEdge(5, 0, 0);
        graph.addEdge(4, 0, 1);
        graph.addEdge(5, 0, 6);
        graph.addEdge(4, 0, 5);
        graph.addEdge(6, 0, 7);
        graph.addEdge(8, 0, 9);
        graph.addEdge(9, 0, 2);
        graph.addEdge(9, 0, 1);
        graph.addEdge(9, 0, 7);


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

