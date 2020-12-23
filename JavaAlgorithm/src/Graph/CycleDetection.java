package Graph;

import java.util.HashSet;

public class CycleDetection {
    static HashSet<Integer> visited = new HashSet<>();

    private static boolean detectCycle(Graph g) {
        for (int i = 0; i < g.vertices; i++) {
            if (cyclic(g, i, new HashSet<>()))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean cyclic(Graph g, int source, HashSet<Integer> curr) {
        if (curr.contains(source)) return true;

        if (visited.contains(source)) return false;

        visited.add(source);
        curr.add(source);

        for (int item : g.adjacentList.get(source)) {
            if (cyclic(g, item, curr))
            {
                return true;
            }
        }
        return false;
    }


    public static void main(String args[]) {
        Graph g1 = new Graph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(detectCycle(g1));

        System.out.println();
        Graph g2 = new Graph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(detectCycle(g2));
    }


}
