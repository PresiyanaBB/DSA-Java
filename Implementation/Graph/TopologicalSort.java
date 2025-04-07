package Implementation.Graph;

import java.util.*;

/// Topological Sort works only when initialized with DirectedGraph
class TopologicalSort {
    private final Graph graph;

    public TopologicalSort(Graph graph) {
        this.graph = graph;
    }

    public void topologicalSort() {
        int vertices = graph.getVertices();
        LinkedList<Integer>[] adjacencyList = graph.getAdjacencyList();

        // Calculate indegree of all vertices
        int[] indegree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for (Integer adjacent : adjacencyList[i]) {
                indegree[adjacent]++;
            }
        }

        // Queue for vertices with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Perform topological sort
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            result.add(vertex);

            for (Integer adjacent : adjacencyList[vertex]) {
                indegree[adjacent]--;
                if (indegree[adjacent] == 0) {
                    queue.add(adjacent);
                }
            }
        }

        // Check for cycles (not a DAG)
        if (result.size() != vertices) {
            System.out.println("The graph is not a DAG (Directed Acyclic Graph).");
        } else {
            System.out.println("Topological Sort: " + result);
        }
    }
}

