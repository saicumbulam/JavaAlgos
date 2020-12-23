package Graph;

import java.util.LinkedList;

public class Graph {
    int vertices;
    LinkedList<LinkedList<Integer>> adjacentList;

    public Graph(int vertices)
    {
        this.vertices = vertices;
        adjacentList = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            adjacentList.add(new LinkedList<>());
        }
    }

    public void addEdge(int source, int destination)
    {
        adjacentList.get(source).add(destination);
        //----------for undirected graph uncomment the line below---
        //adjacentList.get(destination).add(source);
    }

    public void printGraph()
    {
        for (int i = 0; i < vertices; i++) {
            System.out.print("|" + i + "| => ");
            for (int item: adjacentList.get(i)) {
                System.out.print("[" + item + "] ->");
            }
            System.out.println("null");
        }
    }
}
