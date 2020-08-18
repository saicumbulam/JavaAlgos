package Leetcode.TopologicalSort.After;

import java.util.*;

public class CourseSchedule2 {
    public static void main(String[] args) {
        int numCourses = 2;
        List<List<Integer>> prerequisites = new ArrayList<>();
        prerequisites.add(new ArrayList<>());
        prerequisites.get(0).add(1);
        prerequisites.get(0).add(0);
        System.out.println(Calculate(numCourses, prerequisites));
    }
    private static List<Integer> Calculate(int numCourses, List<List<Integer>> prerequisites)
    {
        List<Integer> sortedOrder = new ArrayList<>();
        if (numCourses == 0)
        {
            return sortedOrder;
        }

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses ; i++) {
            inDegree.put(i, inDegree.getOrDefault(i, 0) + 1);
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.size(); i++) {
            int parent = prerequisites.get(i).get(0);
            int child = prerequisites.get(i).get(1);
            inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
            graph.get(parent).add(child);
        }

        Queue<Integer> source = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 1)
            {
                source.add(entry.getKey());
            }
        }

        while (!source.isEmpty())
        {
            int vertex = source.poll();
            sortedOrder.add(0, vertex);  // the 0 is to maintain the sorted order
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 1)
                {
                    source.add(child);
                }
            }
        }

        if (sortedOrder.size() != numCourses)
        {
            return new ArrayList<>();
        }
        return sortedOrder;
    }
}
