package Implementation.Graph;

import java.util.*;

/// Depth-First Search
class DFS {
    private final Graph graph;

    public DFS(Graph graph) {
        this.graph = graph;
    }

    public void depthFirstSearch(int startVertex) {
        boolean[] visited = new boolean[graph.getVertices()];
        dfsHelper(startVertex, visited);
    }

    private void dfsHelper(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (Integer adjacent : graph.getAdjacencyList()[vertex]) {
            if (!visited[adjacent]) {
                dfsHelper(adjacent, visited);
            }
        }
    }
}
