package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumEdgeBetweenTwoVertices {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge( 0, 1);
        g.addEdge( 0, 7);
        g.addEdge( 1, 7);
        g.addEdge( 1, 2);
        g.addEdge( 2, 3);
        g.addEdge( 2, 5);
        g.addEdge( 2, 8);
        g.addEdge( 3, 4);
        g.addEdge( 3, 5);
        g.addEdge( 4, 5);
        g.addEdge( 5, 6);
        g.addEdge( 6, 7);
        g.addEdge( 7, 8);

        minEdgeBFS(g, 0, 5);
    }

    private static void minEdgeBFS(Graph g, int source, int destination) {
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, Integer> distances = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        distances.put(source, 0);

        while (!queue.isEmpty())
        {
            int polled = queue.poll();

            for (int item: g.adjacentList.get(polled)) {
                if (!visited.contains(item))
                {
                    queue.add(item);
                    distances.put(item, distances.get(polled) + 1);
                    visited.add(item);
                }
            }
        }

        System.out.println(distances.get(destination));
    }


}
