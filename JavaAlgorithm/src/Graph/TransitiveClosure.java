package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TransitiveClosure {

    static class Graph
    {
        // No. of vertices in graph
        private int vertices;

        // adjacency list
        private HashMap<Integer, List<Integer>> adjList;

        // To store transitive closure
        private int[][] tc;

        // Constructor
        public Graph(int vertices) {

            this.vertices = vertices;
            this.tc = new int[this.vertices][this.vertices];

            for (int i = 0; i < vertices; i++) {
                adjList.put(i,new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            if (!adjList.containsKey(u)) adjList.put(u, new ArrayList<>());
            adjList.get(u).add(v);
        }

        public void transitiveClosure() {
            for (int i = 0; i < vertices; i++) {
                dfsUtil(i, i);
            }

            for (int i = 0; i < vertices; i++) {
                System.out.println(Arrays.toString(tc[i]));
            }
        }

        private void dfsUtil(int s, int v) {
            tc[s][v] = 1;

            // Find all the vertices reachable
            // through v
            for (int item : adjList.get(v)) {
                if (tc[s][item]==0) {
                    dfsUtil(s, item);
                }
            }
        }
    }

     public static void main(String[] args) {

            // Create a graph given
            // in the above diagram
            Graph g = new Graph(4);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(2, 3);
            g.addEdge(3, 3);
            System.out.println("Transitive closure " +
                    "matrix is");

            g.transitiveClosure();

    }
}
