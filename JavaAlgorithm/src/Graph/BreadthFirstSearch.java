package Graph;

import java.util.*;

public class BreadthFirstSearch {

    static List<Integer> result = new ArrayList<>();
    static HashSet<Integer> visited = new HashSet<>();

    private static void bfsMain(Graph g) {
        if (g.vertices < 1){
            return;
        }

        for (int i = 0; i < g.vertices; i++) {
            if (!visited.contains(i))
            {
                bfs(g, i);
            }
        }
        System.out.println(result);
    }

    private static void bfs(Graph g, int source) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty())
        {
            int polled = queue.poll();
            result.add(polled);

            for (int item: g.adjacentList.get(polled)) {
                if (!visited.contains(item))
                {
                    queue.add(item);
                    visited.add(item);
                }
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
        System.out.println("bfs traversal");
        bfsMain(g);
        System.out.println();



        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("bfs traversal");
        bfsMain(g2);
        System.out.println();
    }
}
