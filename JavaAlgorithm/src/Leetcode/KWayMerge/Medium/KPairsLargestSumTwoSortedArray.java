package Leetcode.KWayMerge.Medium;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsLargestSumTwoSortedArray {
    public static void main(String[] args) {
        int[] l1 = {9,8,2};
        int[] l2 = {6,3,1};
        int k = 3;
        System.out.println(Calculate(l1, l2, k));
    }

    static class Element
    {
        int sum;
        int i;
        int j;

        public Element(int sum, int i, int j)
        {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    private static List<List<Integer>> Calculate(int[] l1, int[] l2, int k)
    {

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a,b) -> a.sum - b.sum);

        for (int i = 0; i < l1.length; i++) {
            for (int j = 0; j < l2.length; j++) {
                int sum = l1[i] + l2[j];
                if (!minHeap.isEmpty() && sum < minHeap.peek().sum && minHeap.size() >= k)
                {
                    continue;
                }
                minHeap.add(new Element(sum, l1[i], l2[j]));
                if (minHeap.size() > k)
                {
                    minHeap.poll();
                }
            }
        }

        while (!minHeap.isEmpty())
        {
            Element e = minHeap.poll();
            result.add(Arrays.asList(e.i, e.j));
        }

        return result;
    }

}
