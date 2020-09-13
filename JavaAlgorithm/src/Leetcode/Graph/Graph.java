package Leetcode.Graph;

import Leetcode.LinkedList.DoubleLinkedList;

public class Graph {
    public int vertices;
    public DoubleLinkedList[] adjacencyList;

    public Graph(int vertices)
    {
        this.vertices = vertices;
        adjacencyList = new DoubleLinkedList[vertices];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new DoubleLinkedList();
        }
    }


    public void addEdge(int source, int destination)
    {
        adjacencyList[source].insertAtEnd(destination);
    }

    public int getVertices()
    {
        return vertices;
    }

    public DoubleLinkedList[] getList()
    {
        return adjacencyList;
    }

    public void printGraph()
    {
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < vertices; i++)
        {
            if(adjacencyList[i]!=null){
                System.out.print("|" + i + "| => ");

                DoubleLinkedList.Node temp = adjacencyList[i].getHeadNode();
                while (temp != null)
                {
                    System.out.print("[" + temp.data + "] -> ");
                    temp = temp.nextNode;
                }
                System.out.println("null");
            }
            else{

                System.out.println("|" + i + "| => "+ "null");
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
    }
}


