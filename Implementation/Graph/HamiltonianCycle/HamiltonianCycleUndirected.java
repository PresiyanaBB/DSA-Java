package Implementation.Graph.HamiltonianCycle;

import Implementation.Graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class HamiltonianCycleUndirected {
    private Graph graph;
    private int V;
    private List<Integer> path;

    public HamiltonianCycleUndirected(Graph graph) {
        this.graph = graph;
        this.V = graph.getVertices();
        this.path = new ArrayList<>();
    }

    public boolean hasHamiltonianCycle() {
        path.clear();
        path.add(0); // Start at vertex 0
        return backtrack(1);
    }

    public List<Integer> getHamiltonianCycle() {
        if (hasHamiltonianCycle()) {
            path.add(path.get(0)); // Close the cycle
            return new ArrayList<>(path);
        } else {
            return null;
        }
    }

    private boolean backtrack(int position) {
        if (position == V) {
            // Check if last vertex connects to first
            return graph.getAdjacencyList()[path.get(position - 1)].contains(path.get(0));
        }

        for (int v = 1; v < V; v++) {
            if (isSafe(v, position)) {
                path.add(v);
                if (backtrack(position + 1)) {
                    return true;
                }
                path.remove(path.size() - 1); // Backtrack
            }
        }
        return false;
    }

    private boolean isSafe(int v, int pos) {
        // Must be adjacent to previous vertex
        if (!graph.getAdjacencyList()[path.get(pos - 1)].contains(v)) return false;

        // Must not already be in the path
        return !path.contains(v);
    }
}

