package Graph;

import java.util.*;

public class BestFirstSearch {
    static class Node
    {
        int value;
        int cost;

        public Node(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }
    }
    static HashMap<Integer, List<Node>> graph = new HashMap<>();


    public static void main(String[] args) {
        addEdge(0, 1, 3);
        addEdge(0, 2, 6);
        addEdge(0, 3, 5);
        addEdge(1, 4, 9);
        addEdge(1, 5, 8);
        addEdge(2, 6, 12);
        addEdge(2, 7, 14);
        addEdge(3, 8, 7);
        addEdge(8, 9, 5);
        addEdge(8, 10, 6);
        addEdge(9, 11, 1);
        addEdge(9, 12, 10);
        addEdge(9, 13, 2);

        best_first(0, 9);
    }

    private static void best_first(int source, int destination) {
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b) -> a.cost - b.cost);

        minHeap.add(new Node(source, 0));
        visited.add(source);

        List<Integer> list = new ArrayList<>();

        while (!minHeap.isEmpty())
        {
            Node polled = minHeap.poll();
            list.add(polled.value);

            if (polled.value == destination) break;
            for (Node item: graph.get(polled.value)) {
                if (!visited.contains(item.value))
                {
                    minHeap.add(item);
                    visited.add(item.value);
                }
            }
        }

        System.out.println(list);
    }

    private static void addEdge(int source, int destination, int cost) {
        if (!graph.containsKey(source)) graph.put(source, new ArrayList<>());
        graph.get(source).add(new Node(destination, cost));
    }
}
