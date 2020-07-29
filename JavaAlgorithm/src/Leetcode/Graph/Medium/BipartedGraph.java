package Leetcode.Medium;

import Leetcode.LinkedList.DoubleLinkedList;
import Leetcode.DataStructures.Graph;

public class BipartedGraph {
    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 1);

        boolean[] discovered = new boolean[8];
        boolean[] color = new boolean[8];
        discovered[1] = true;
        color[1] = false;


        //Example 1
        boolean x = isBipartite(g, 1, discovered, color);
        System.out.println("Graph1 is bipartite: " + x);
    }

    private static boolean isBipartite(Graph g, int source, boolean[] visited, boolean[] color) {
        DoubleLinkedList.Node temp = g.adjacencyList[source].getHeadNode();

        while (temp != null)
        {
            if (!visited[temp.data])
            {
                visited[temp.data] = true;
                color[temp.data] = true;
                if (!isBipartite(g, temp.data, visited, color))
                {
                    return false;
                }
            }
            else if (color[source] == color[temp.data])
            {
                return false;
            }
            temp = temp.nextNode;
        }

        return true;
    }
}
