package Implementation.Graph;

import java.util.*;

public class DirectedGraph extends Graph {
    // Constructor
    public DirectedGraph(int vertices) {
        super(vertices);
    }

    // Override the addEdge method for directed graph
    @Override
    public void addEdge(int source, int destination) {
        getAdjacencyList()[source].add(destination); // Only add edge in one direction
    }

    @Override
    public boolean isDirected() {
        return true;
    }

    /// reverse every direction
    public DirectedGraph transpose() {
        DirectedGraph reverseGraph = new DirectedGraph(this.getVertices());
        for (int i = 0; i < this.getVertices(); i++) {
            for (int neighbor : this.getAdjacencyList()[i]) {
                reverseGraph.addEdge(neighbor, i); // Reverse the edge direction
            }
        }
        return reverseGraph;
    }
}

