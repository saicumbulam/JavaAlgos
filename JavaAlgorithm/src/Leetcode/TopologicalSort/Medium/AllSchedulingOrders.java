package Leetcode.Medium;

import java.util.*;

public class AllSchedulingOrders {
    public static void main(String[] args) {
        int tasks = 6;
        int[][] preReq = {{2,5},{0,5},{0,4},{1,4},{3,2},{1,3}};
        Calculate(tasks, preReq);
    }

    private static void Calculate(int tasks, int[][] preReq) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (tasks <= 0)
        {
            return;
        }
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i,0);
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < preReq.length; i++) {
            int parent = preReq[i][0], child = preReq[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child)+1);
        }

        Queue<Integer> source = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: inDegree.entrySet()
             ) {
            if (entry.getValue() == 0)
            {
                source.add(entry.getKey());
            }
        }

        printAllToplogy(graph, inDegree, source, sortedOrder);
    }

    private static Queue<Integer> cloneQueue(Queue<Integer> queue)
    {
        Queue<Integer> temp = new LinkedList<>();
        for(Integer num: queue)
        {
            temp.add(num);
        }
        return temp;
    }

    private static void printAllToplogy(HashMap<Integer, List<Integer>> graph, HashMap<Integer, Integer> inDegree, Queue<Integer> source, List<Integer> sortedOrder) {
        if (!source.isEmpty())
        {
            for (int vertex: source
                 ) {
                sortedOrder.add(vertex);
                Queue<Integer> sourcesNextCall = cloneQueue(source);
                sourcesNextCall.remove(vertex);

                List<Integer> children = graph.get(vertex);

                for (int child: children
                     ) {
                    inDegree.put(child, inDegree.get(child)-1);
                    if (inDegree.get(child) == 0)
                    {
                        sourcesNextCall.add(child);
                    }
                }

                printAllToplogy(graph, inDegree, sourcesNextCall, sortedOrder);
                sortedOrder.remove(vertex);
                for (int child: children
                     ) {
                    inDegree.put(child, inDegree.get(child)+1);
                }
            }
        }

        if (sortedOrder.size() == inDegree.size())
        {
            System.out.println(sortedOrder);
        }
    }
}
