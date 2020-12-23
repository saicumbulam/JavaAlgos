package Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class FindMotherVertex {

    static HashSet<Integer> visited = new HashSet<>();

    private static int findMotherVertex(Graph g) {
        int lastVertex = 0;
        for (int i = 0; i < g.vertices; i++) {
           if (!visited.contains(i))
           {
               dfs(g, i);
               lastVertex = i;
           }
        }

        visited = new HashSet<>();
        dfs(g, lastVertex);
        for (int i = 0; i < g.vertices; i++) {
            if (!visited.contains(i)) return -1;
        }
        return lastVertex;
    }

    private static void dfs(Graph g, int source) {
        visited.add(source);

        for (int item: g.adjacentList.get(source)) {
            if (!visited.contains(item))
            {
                dfs(g, item);
            }
        }
    }

    public static void main(String args[]) {

        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,1);
        g.printGraph();
        System.out.println("Mother Vertex is: " + findMotherVertex(g));
    }
}
