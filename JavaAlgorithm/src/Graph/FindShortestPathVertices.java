package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FindShortestPathVertices {
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(1,4);
        System.out.println(findMin(g, 0, 4));
    }

    private static int findMin(Graph g, int source, int destination) {
        if (source == destination) return 0;

        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, Integer> distance = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {

            int polled = queue.poll();

            for (int item: g.adjacentList.get(polled)) {
                if (!visited.contains(item)) {
                    queue.add(item);
                    visited.add(item);
                    distance.put(item, distance.getOrDefault(polled, 0) + 1);
                }

                if (item == destination) return distance.get(item);
            }
        }//end of while
        return -1;
    }
}
