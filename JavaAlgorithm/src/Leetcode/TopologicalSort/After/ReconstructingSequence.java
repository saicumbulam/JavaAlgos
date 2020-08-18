package Leetcode.TopologicalSort.After;

import java.util.*;

public class ReconstructingSequence {
    public static void main(String[] args) {
        int[] originalSeq = {1,2,3,4};
        int[][] seqs = {{1,2}, {2,3}, {3,4}};
        System.out.println(Calculate(originalSeq, seqs));
    }

    private static boolean Calculate(int[] originalSeq, int[][] seqs) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (originalSeq.length <= 0)
        {
            return false;
        }

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] seq: seqs
             ) {
            for (int i = 0; i < seq.length; i++) {
                inDegree.putIfAbsent(seq[i], 0);
                graph.putIfAbsent(seq[i], new ArrayList<>());
            }
        }

        for (int[] seq: seqs
        ) {
            for (int i = 1; i < seq.length; i++) {
                int parent = seq[i-1], child = seq[i];
                graph.get(parent).add(child);
                inDegree.put(child, inDegree.get(child)+1);
            }
        }

        if (inDegree.size() != originalSeq.length)
        {
            return false;
        }

        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer,Integer> entry: inDegree.entrySet()
             ) {
            if (entry.getValue() == 0)
            {
                sources.add(entry.getKey());
            }
        }


        while (!sources.isEmpty())
        {
            if (sources.size() > 1)
            {
                return false;
            }

            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);
            for (int child: children
                 ) {
                inDegree.put(child, inDegree.get(child)-1);
                if (inDegree.get(child) == 0)
                {
                    sources.add(child);
                }
            }
        }

        return sortedOrder.size() == originalSeq.length;
    }


}
