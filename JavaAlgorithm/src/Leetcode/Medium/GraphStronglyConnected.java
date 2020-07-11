package Leetcode.Medium;

import Leetcode.DataStructures.DoubleLinkedList;
import Leetcode.DataStructures.Graph;

public class GraphStronglyConnected {
    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);

        Object x = isStronglyConnected(g1);
        System.out.println("Graph g1 is strongly connected? " + x);
    }

    private static boolean isStronglyConnected(Graph g)
    {
        boolean[] visited = new boolean[g.vertices];
        FillVisited(g, 0, visited);
        // if graph has any unvisited nodes return false
        for (int i = 0; i < g.vertices; i++)
            if (visited[i] == false)
                return false;

        // NOW CHECK FOR TRANSPOSED GRAPH

        // find the transpose of the graph
        Graph g1 = Transpose(g);

        for (int i = 0; i < g1.vertices; i++)
            visited[i] = false;

        // check transposed graph for non visited vertices
        FillVisited(g1, 0, visited);

        // if transpose of graph has any unvisited nodes return false
        for (int i = 0; i < g1.vertices; i++)
            if (visited[i] == false)
                return false;

        return true;
    }


    private static Graph Transpose(Graph g)
    {
        Graph transposedGraph = new Graph(g.vertices);
        DoubleLinkedList[] temp = g.getList();

        for (int v = 0; v < g.vertices; v++) {
            DoubleLinkedList.Node node = temp[v].getHeadNode();
            while (node != null) {
                transposedGraph.addEdge(node.data,v); // reverse the connections
                node = node.nextNode;
            }
        }
        return transposedGraph;
    }

    private static void FillVisited(Graph g, int source, boolean[] visited)
    {
        visited[source] = true;
        DoubleLinkedList[] list = g.getList();
        DoubleLinkedList.Node temp = list[source].getHeadNode();

        while (temp != null)
        {
            if (!visited[temp.data])
            {
                FillVisited(g, temp.data, visited);
            }
            temp = temp.nextNode;
        }
    }
}
