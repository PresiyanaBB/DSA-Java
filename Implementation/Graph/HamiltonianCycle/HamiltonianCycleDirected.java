package Implementation.Graph.HamiltonianCycle;

import Implementation.Graph.DirectedGraph;

import java.util.ArrayList;
import java.util.List;

public class HamiltonianCycleDirected {
    private DirectedGraph graph;
    private int V;
    private List<Integer> path;

    public HamiltonianCycleDirected(DirectedGraph graph) {
        this.graph = graph;
        this.V = graph.getVertices();
        this.path = new ArrayList<>();
    }

    public boolean hasHamiltonianCycle() {
        path.clear();
        path.add(0); // Start from vertex 0
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
            // Final vertex must connect back to the start to complete the cycle
            return graph.getAdjacencyList()[path.get(position - 1)].contains(path.get(0));
        }

        for (int v = 1; v < V; v++) {
            if (isSafe(v, position)) {
                path.add(v);
                if (backtrack(position + 1)) {
                    return true;
                }
                path.remove(path.size() - 1); // backtrack
            }
        }
        return false;
    }

    private boolean isSafe(int v, int pos) {
        // Must be reachable from previous vertex
        if (!graph.getAdjacencyList()[path.get(pos - 1)].contains(v)) return false;

        // Must not already be in the path
        return !path.contains(v);
    }
}
