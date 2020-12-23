package Graph;

import java.util.HashSet;
import java.util.Stack;

public class CheckPathsBetweenVertices {
    public static void main(String[] args) {
        Graph g1 = new Graph(9);
        g1.addEdge(0,2);
        g1.addEdge(0,5);
        g1.addEdge(2,3);
        g1.addEdge(2,4);
        g1.addEdge(5,3);
        g1.addEdge(5,6);
        g1.addEdge(3,6);
        g1.addEdge(6,7);
        g1.addEdge(6,8);
        g1.addEdge(6,4);
        g1.addEdge(7,8);
        g1.printGraph();
        System.out.println("Path exists: " + checkPath(g1, 0, 7));
        System.out.println();
    }

    private static boolean checkPath(Graph g, int source, int destination) {
        if (source == destination) return true;

        HashSet<Integer> visited = new HashSet<>();
        return dfs(g, source, destination, visited);
    }


    private static boolean dfs(Graph g, int source, int destination, HashSet<Integer> visited)
    {
        if (source == destination) return true;
        visited.add(source);

        for (int item: g.adjacentList.get(source)) {
            if (!visited.contains(item) && dfs(g, item, destination,visited))
            {
                return true;
            }
        }

        return false;
    }
}
