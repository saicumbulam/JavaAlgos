package Leetcode.Medium;

import Leetcode.DataStructures.DoubleLinkedList;
import Leetcode.DataStructures.Graph;

public class GraphTranspose {
    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);
        g1.printGraph();
        System.out.println("Transpose of given Graph: ");
        getTranspose(g1);
    }

    private static void getTranspose(Graph g) {
        Graph transposedGraph = new Graph(g.vertices);
        DoubleLinkedList[] temp = g.getList();

        for (int v = 0; v < g.vertices; v++) {
            DoubleLinkedList.Node node = temp[v].getHeadNode();
            while (node != null) {
                transposedGraph.addEdge(node.data,v); // reverse the connections
                node = node.nextNode;
            }
        }

        transposedGraph.printGraph();
    }
}
