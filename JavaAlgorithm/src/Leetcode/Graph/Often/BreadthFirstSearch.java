/*
Load visitor during queue push
* */
package Leetcode.Graph.Often;

import Leetcode.LinkedList.DoubleLinkedList;
import Leetcode.Graph.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " + bfs(g));
        System.out.println();
    }

    public static String bfs(Graph g)
    {
        String result = "";
        if (g.getVertices() < 1)
        {
            return result;
        }

        boolean[] visited = new boolean[g.getVertices()];

        for (int i = 0; i < g.getVertices(); i++) {
            if (!visited[i])
            {
                result = result + bfsVisit(g, i, visited);
            }
        }

        return result;
    }

    private static String bfsVisit(Graph g, int source, boolean[] visited)
    {
        String result = "";
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty())
        {
            int current_node = queue.poll();
            result += String.valueOf(current_node);

            DoubleLinkedList.Node temp = null;
            if (g.adjacencyList[current_node] != null)
            {
                temp = g.adjacencyList[current_node].getHeadNode();
            }

            while (temp != null)
            {
                if (!visited[temp.data])
                {
                    queue.add(temp.data);
                    visited[temp.data] = true;
                }
                temp = temp.nextNode;
            }
        }
        return result;
    }


}
