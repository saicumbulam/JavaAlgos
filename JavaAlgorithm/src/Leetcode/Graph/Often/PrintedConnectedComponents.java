package Leetcode.Graph.Often;

import Leetcode.LinkedList.DoubleLinkedList;
import Leetcode.Graph.Graph;

public class PrintedConnectedComponents {
    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(5, 3);
        g.addEdge(5, 6);
        g.addEdge(3, 6);

        System.out.println("The connected components are:");
        printConnectedComponents(g);
    }

    private static void printConnectedComponents(Graph g)
    {
        boolean[] visited = new boolean[g.vertices];
        for (int i = 0; i < g.vertices; i++) {
            if (!visited[i])
            {
                FillArray(g, i, visited);
            }
            System.out.println();
        }
    }

    private static void FillArray(Graph g, int source, boolean[] visited)
    {
        visited[source] = true;
        System.out.print(source + " ");
        DoubleLinkedList.Node current = g.adjacencyList[source].getHeadNode();

        while (current != null )
        {
            if (!visited[current.data])
            {
                FillArray(g, current.data, visited);
            }
        }
    }
}
