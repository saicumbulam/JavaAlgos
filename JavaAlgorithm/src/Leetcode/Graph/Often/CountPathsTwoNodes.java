package Leetcode.Graph.Often;

import Leetcode.LinkedList.DoubleLinkedList;
import Leetcode.Graph.Graph;

import java.util.HashMap;

public class CountPathsTwoNodes {
    public static void main(String[] args) {
        int answer;
        Graph g1 = new Graph(6);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(3, 4);
        g1.addEdge(2, 3);
        g1.addEdge(4, 5);

        answer = countPaths(g1, 0, 5);
        System.out.println(answer);
    }

    private static int countPaths(Graph g, int source, int dest) {
        int count = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        DoubleLinkedList[] list = g.adjacencyList;

        if (source == dest)
        {
            return 1;
        }

        if (hashMap.containsValue(source))
        {
            return 0;
        }
        else {
            DoubleLinkedList.Node temp = list[source].getHeadNode();
            while (temp != null)
            {
                int x = countPaths(g, temp.data, dest);
                count += x;
                hashMap.put(x, temp.data);
                temp = temp.nextNode;
            }

        }
        return count;
    }
}
