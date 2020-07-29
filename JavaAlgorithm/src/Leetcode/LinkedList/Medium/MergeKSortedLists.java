package Leetcode.LinkedList.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    static class Node
    {
        int arrayIdx;
        int elemIdx;

        public Node(int arrayIdx, int elemIdx) {
            this.arrayIdx = arrayIdx;
            this.elemIdx = elemIdx;
        }
    }

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1,2,3,4,5,6});
        list.add(new int[]{1,2,3,4,5,6});
        list.add(new int[]{1,2,3,4,5,6});
        list.add(new int[]{1,2,3,4,5,6});
        List<Integer> result = Calculate(list);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static List<Integer> Calculate(List<int[]> list)
    {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> list.get(n1.arrayIdx)[n1.elemIdx] -
                list.get(n2.arrayIdx)[n2.elemIdx]);

        for (int i = 0; i < list.size(); i++) {
            minHeap.add(new Node(i, 0));
        }

        while (!minHeap.isEmpty())
        {
            Node node = minHeap.poll();
            result.add(list.get(node.arrayIdx)[node.elemIdx]);
            if (node.elemIdx < list.get(node.arrayIdx).length-1) //watch out for this
            {
                minHeap.add(new Node(node.arrayIdx, node.elemIdx+1));
            }
        }

        return result;
    }
}
