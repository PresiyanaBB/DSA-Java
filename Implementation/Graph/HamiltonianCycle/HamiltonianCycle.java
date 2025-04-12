package Implementation.Graph.HamiltonianCycle;

import Implementation.Graph.Graph;
import Implementation.Graph.DirectedGraph;

import java.util.List;

public class HamiltonianCycle {

    public static void UndirectedExample() {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
//        g.addEdge(4, 0);  // Add this one edge to make a cycle
        g.addEdge(1, 3);

        HamiltonianCycleUndirected finder = new HamiltonianCycleUndirected(g);
        List<Integer> cycle = finder.getHamiltonianCycle();

        if (cycle != null) {
            System.out.println("Hamiltonian Cycle found:");
            System.out.println(cycle);
        } else {
            System.out.println("No Hamiltonian Cycle found.");
        }
    }

    public static void DirectedExample() {
        DirectedGraph g = new DirectedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
//        g.addEdge(3, 0);  // Add this one edge to make a cycle

        HamiltonianCycleDirected finder = new HamiltonianCycleDirected(g);
        List<Integer> cycle = finder.getHamiltonianCycle();

        if (cycle != null) {
            System.out.println("Hamiltonian Cycle in directed graph:");
            System.out.println(cycle);
        } else {
            System.out.println("No Hamiltonian Cycle found.");
        }
    }
}
