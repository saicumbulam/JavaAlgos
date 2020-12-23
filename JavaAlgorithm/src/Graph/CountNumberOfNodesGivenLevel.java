package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CountNumberOfNodesGivenLevel {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);

        int level = 2;

        System.out.println(bfs(g, 0, level));
    }

    static class Node
    {
        int value;
        int depth;

        public Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }

    private static int bfs(Graph g, int source, int level) {
        HashSet<Integer> visited = new HashSet<>();
        int sum = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(source, 0));
        visited.add(source);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node polled = queue.poll();

                if (polled.depth == level)
                    sum++;

                if (polled.depth > level) continue;

                for (int item: g.adjacentList.get(polled.value)) {
                    if (!visited.contains(item))
                    {
                        queue.add(new Node(item, polled.depth+1));
                        visited.add(item);
                    }
                }
            }
        }
        return sum;
    }


}
