package Graph;

import java.util.HashSet;
import java.util.Stack;

public class CheckGraphisTree {

    private static boolean isTree(Graph g) {
        //1. Check each node other than root has exactly one parent.
        if (!checkOneParent(g))
            return false;

        //2. Check for Cycle
        if (detectCycle(g))
            return false;

        //2. Check for connectivity
        if (!checkConnected(g, 0))
            return false;

        return true;
    }

    public static boolean detectCycle(Graph g) {
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < g.vertices; i++) {
            if (cyclic(g, i, visited, new HashSet<>())) {
                return true;
            }
        }
        return false;
    }

    public static boolean cyclic(Graph g, int source, HashSet<Integer> visited, HashSet<Integer> curr) {
        if (curr.contains(source)) return true;

        if (visited.contains(source)) return false;

        visited.add(source);
        curr.add(source);

        for (int item: g.adjacentList.get(source)) {
            if (cyclic(g, item, visited, curr)) {
                return true;
            }
        }

        curr.remove(source);
        return false;
    }

    public static boolean checkOneParent(Graph g) {
        HashSet<Integer> hasOneParent = new HashSet<>();

        for (int i = 0; i < g.vertices; i++) {
            for (int item: g.adjacentList.get(i)) {
                if (hasOneParent.contains(item))
                {
                    return false;
                }
                hasOneParent.add(item);
            }
        }

        for (int i = 0; i < g.vertices; i++) {
            if (i == 0 && hasOneParent.contains(i)) {
                return false;
            }
            else if (i != 0 && !hasOneParent.contains(i)) {
                return false;
            }
        }
        return true;
    }

    static int vertices_reached = 0;
    private static boolean checkConnected(Graph g, int source) {

        HashSet<Integer> visited = new HashSet<>();
        dfsCheckConnected(g, source, visited);

        //+1 for source, and if number of vertices reachable from source are equal
        //to the total number of vertices in graph then return true else false.
        return vertices_reached == g.vertices;
    }

    private static void dfsCheckConnected(Graph g, int source, HashSet<Integer> visited)
    {
        visited.add(source);
        vertices_reached += 1;

        for (int item: g.adjacentList.get(source)) {
            if (!visited.contains(item))
            {
                dfsCheckConnected(g, item, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(3,4);
        g.printGraph();
        System.out.println("isTree : " + isTree(g));
    }
}
