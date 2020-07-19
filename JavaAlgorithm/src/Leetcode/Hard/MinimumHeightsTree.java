package Leetcode.Hard;

import java.util.*;

public class MinimumHeightsTree {
    public static void main(String[] args) {
        int vertices = 5;
        int[][] arr = {{0,1},{1,2},{1,3},{2,4}};
        for (int item: Calculate(vertices, arr)) {
            System.out.println(item);
        };
    }

    private static List<Integer> Calculate(int nodes, int[][] edges) {
        List<Integer> minHeights = new ArrayList<>();
        if (nodes <= 0)
        {
            return minHeights;
        }

        if (nodes == 1)
        {
            minHeights.add(0);
            return minHeights;
        }

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < nodes; i++) {
            inDegree.put(i,0);
            graph.put(i, new ArrayList<>());
        }

        //Build graph
        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0], n2 = edges[i][1];
            // since this is an undirected graph,
            // therefore add a link for both the nodes
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);

            //increment the indegrees of both the nodes
            inDegree.put(n1, inDegree.get(n1)+1);
            inDegree.put(n2, inDegree.get(n2)+1);
        }

        //Find leaves
        Queue<Integer> leaves = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: inDegree.entrySet()
             ) {
            if (entry.getValue() == 1)
            {
                leaves.add(entry.getKey());
            }
        }

        //Remove leaves level by level
        // subtract each levels children indegrees
        // Repeat this unto we end up with 1 or 2 nodes.
        int totalNodes = nodes;
        while (totalNodes > 2)
        {
            int leavesSize = leaves.size();
            totalNodes -= leavesSize;

            for (int i = 0; i < leavesSize; i++) {
                int vertex = leaves.poll();
                List<Integer> children = graph.get(vertex);
                for (int child: children
                     ) {
                    inDegree.put(child, inDegree.get(child)-1);
                    if (inDegree.get(child) == 1)
                    {
                        leaves.add(child);
                    }
                }
            }
        }

        minHeights.addAll(leaves);
        return minHeights;
    }
}
