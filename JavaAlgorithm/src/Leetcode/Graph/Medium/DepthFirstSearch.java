package Leetcode.Graph.Medium;

import Leetcode.LinkedList.DoubleLinkedList;
import Leetcode.Graph.Graph;

import java.util.Stack;

public class DepthFirstSearch {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("DFS traversal of Graph1 : " + dfs(g));
        System.out.println();
    }

    private static String dfs(Graph g) {
        String result = "";

        if (g.vertices < 1)
        {
            return result;
        }

        boolean[] visited = new boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++) {
            if (!visited[i])
            {
                result = result + dfsVisit(g, i, visited);
            }
        }

        return result;
    }

    private static String dfsVisit(Graph g, int source, boolean[] visited) {
        String result = "";


        //Create Stack(Implemented in previous lesson) for Depth First Traversal and Push source in it
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(source);

        //Traverse while stack is not empty
        while (!stack.isEmpty()) {

            //Pop a vertex/node from stack and add it to the result
            int current_node = stack.pop();
            result += String.valueOf(current_node);

            //Get adjacent vertices to the current_node from the array,
            //and if they are not already visited then push them in the stack
            DoubleLinkedList.Node temp = null;
            if(g.adjacencyList[current_node] !=null)
                temp = g.adjacencyList[current_node].getHeadNode();

            while (temp != null) {

                if (!visited[temp.data]) {
                    stack.push(temp.data);

                }
                temp = temp.nextNode;
            }
            //Visit the node
            visited[current_node] = true;
        }//end of while
        return result;
    }


}
