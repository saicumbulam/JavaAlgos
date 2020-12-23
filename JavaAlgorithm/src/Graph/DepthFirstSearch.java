package Graph;

import java.util.*;

public class DepthFirstSearch {

    static List<Integer> result = new ArrayList<>();
    static HashSet<Integer> visited = new HashSet<>();

    private static void dfsMain(Graph g) {
        if (g.vertices < 1){
            return;
        }

        for (int i = 0; i < g.vertices; i++) {
            if (!visited.contains(i))
            {
                dfs(g, i);
            }
        }
        System.out.println(result);
    }

    private static void dfs(Graph g, int source) {
        result.add(source);
        visited.add(source);

        for (int item: g.adjacentList.get(source)) {
            if (!visited.contains(item))
            {
                dfs(g, item);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        dfsMain(g);
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(4,3);
        System.out.println("Graph2:");
        g2.printGraph();
        dfsMain(g2);
    }
}
