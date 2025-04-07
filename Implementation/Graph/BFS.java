package Implementation.Graph;

import java.util.*;

/// Breadth-Fist Search
class BFS {
    private final Graph graph;

    public BFS(Graph graph) {
        this.graph = graph;
    }

    public void breadthFirstSearch(int startVertex) {
        boolean[] visited = new boolean[graph.getVertices()];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (Integer adjacent : graph.getAdjacencyList()[vertex]) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    queue.add(adjacent);
                }
            }
        }
    }
}

