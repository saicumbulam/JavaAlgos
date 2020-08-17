package Leetcode.Graph.Often;

import Leetcode.LinkedList.DoubleLinkedList;
import Leetcode.Graph.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberNodesGraphLevel {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(2, 4);

        int answer;

        answer = numberOfNodesInGivenLevel(g, 0, 2);
        System.out.println(answer);
    }

    private static int numberOfNodesInGivenLevel(Graph g, int source, int level) {
        int count = 0;

        int[] visited = new int[g.vertices];

        Queue<Integer> queue = new LinkedList<>();
        visited[source] = 1;
        queue.add(source);

        while (!queue.isEmpty())
        {
            int currentNode = queue.poll();

            DoubleLinkedList.Node temp = null;
            if (g.adjacencyList[currentNode] != null)
            {
                temp = g.adjacencyList[currentNode].getHeadNode();
            }

            while (temp != null)
            {
                if (visited[temp.data] != 1)
                {
                    visited[temp.data] = visited[currentNode] + 1;
                    if(visited[temp.data] < level)
                    {
                        queue.add(temp.data);
                    }
                }
                temp = temp.nextNode;
            }
        }

        for (int i = 0; i < g.vertices; i++) {
            if (visited[i] == level)
            {
                count++;
            }
        }

        return count;
    }
}
