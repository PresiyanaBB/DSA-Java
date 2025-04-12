package Implementation.Graph.EulerianCycle;

import Implementation.Graph.Graph;

public class EulerianCycleUndirected {
    private final Graph graph;

    // Constructor
    public EulerianCycleUndirected(Graph graph) {
        this.graph = graph;
    }

    // Method to check if the graph has an Eulerian cycle
    public boolean hasEulerianCycle() {
        // Step 1: Check if all vertices with non-zero degree are connected
        if (!isConnected()) {
            return false;
        }

        // Step 2: Check if all vertices with non-zero degree have even degree
        for (int i = 0; i < graph.getVertices(); i++) {
            if (graph.getAdjacencyList()[i].size() % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    // Helper method to check if all vertices with non-zero degree are connected
    private boolean isConnected() {
        boolean[] visited = new boolean[graph.getVertices()];
        int startVertex = -1;

        // Find a vertex with a non-zero degree
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!graph.getAdjacencyList()[i].isEmpty()) {
                startVertex = i;
                break;
            }
        }

        // If there are no edges in the graph, it's Eulerian
        if (startVertex == -1) {
            return true;
        }

        // Perform DFS starting from the first vertex with a non-zero degree
        dfs(startVertex, visited);

        // Check if all vertices with non-zero degree were visited
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!graph.getAdjacencyList()[i].isEmpty() && !visited[i]) {
                return false;
            }
        }
        return true;
    }

    // DFS helper method
    private void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (int neighbor : graph.getAdjacencyList()[vertex]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }
}
