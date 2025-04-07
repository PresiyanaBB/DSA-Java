package Implementation.Graph.EulerianCycle;

import Implementation.Graph.DirectedGraph;

import java.util.*;

public class EulerianCycleDirected {
    private final DirectedGraph graph;

    // Constructor
    public EulerianCycleDirected(DirectedGraph graph) {
        this.graph = graph;
    }

    // Method to check if the graph has an Eulerian cycle
    public boolean hasEulerianCycle() {
        // Step 1: Check if all vertices with outgoing/incoming edges are strongly connected
        if (!isStronglyConnected()) {
            return false;
        }

        // Step 2: Check if in-degree equals out-degree for all vertices
        int[] inDegrees = new int[graph.getVertices()];
        int[] outDegrees = new int[graph.getVertices()];

        for (int i = 0; i < graph.getVertices(); i++) {
            for (int neighbor : graph.getAdjacencyList()[i]) {
                outDegrees[i]++;
                inDegrees[neighbor]++;
            }
        }

        for (int i = 0; i < graph.getVertices(); i++) {
            if (inDegrees[i] != outDegrees[i]) {
                return false;
            }
        }

        return true;
    }

    // Helper method to check if all vertices with outgoing/incoming edges are strongly connected
    private boolean isStronglyConnected() {
        // Step 1: Perform DFS from any vertex with outgoing/incoming edges
        boolean[] visited = new boolean[graph.getVertices()];
        int startVertex = -1;

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!graph.getAdjacencyList()[i].isEmpty()) {
                startVertex = i;
                break;
            }
        }

        // If no edges are found, the graph is Eulerian
        if (startVertex == -1) {
            return true;
        }

        dfs(startVertex, visited);

        // Check if all vertices with outgoing/incoming edges are visited
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!graph.getAdjacencyList()[i].isEmpty() && !visited[i]) {
                return false;
            }
        }

        // Step 2: Reverse the graph and perform DFS again
        DirectedGraph reversedGraph = graph.transpose();
        visited = new boolean[graph.getVertices()];
        dfs(startVertex, visited, reversedGraph);

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!graph.getAdjacencyList()[i].isEmpty() && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    // Helper method to perform DFS on the reversed graph
    private void dfs(int vertex, boolean[] visited, DirectedGraph graphToUse) {
        visited[vertex] = true;
        for (int neighbor : graphToUse.getAdjacencyList()[vertex]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graphToUse);
            }
        }
    }

    // Helper method to perform DFS on the original graph
    private void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (int neighbor : graph.getAdjacencyList()[vertex]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }
}
