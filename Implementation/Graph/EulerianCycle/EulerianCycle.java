package Implementation.Graph.EulerianCycle;

import Implementation.Graph.Graph;
import Implementation.Graph.DirectedGraph;

public class EulerianCycle {

    public static void UndirectedExample() {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
//        graph.addEdge(4, 0); // Add this one edge to make a cycle

        EulerianCycleUndirected eulerianCheck = new EulerianCycleUndirected(graph);
        if (eulerianCheck.hasEulerianCycle()) {
            System.out.println("The graph has an Eulerian cycle.");
        } else {
            System.out.println("The graph does not have an Eulerian cycle.");
        }
    }


    public static void DirectedExample() {
        DirectedGraph graph = new DirectedGraph(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(1, 3);
//        graph.addEdge(3, 1); // Add this one edge to make a cycle

        EulerianCycleDirected eulerianCheck = new EulerianCycleDirected(graph);
        if (eulerianCheck.hasEulerianCycle()) {
            System.out.println("The graph has an Eulerian cycle.");
        } else {
            System.out.println("The graph does not have an Eulerian cycle.");
        }
    }

}
