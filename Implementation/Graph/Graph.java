package Implementation.Graph;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // For undirected graph
    }

    public LinkedList<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }

    public int getVertices() {
        return vertices;
    }

    public boolean isDirected() {
        return false;
    }

    // Method to display the graph
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer adjacent : adjacencyList[i]) {
                System.out.print(" -> " + adjacent);
            }
            System.out.println();
        }
    }
}

