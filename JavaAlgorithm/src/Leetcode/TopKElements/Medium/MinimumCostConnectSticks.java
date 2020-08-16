/*
Done
Time complexity : o(logn)
space complexity : o(n)

1. Add numbers to MinHeap.
2. while minHeap.size > 1, temp = poll + poll,
   result += temp. poll the temp to minHeap
* */
package Leetcode.TopKElements.Medium;

import java.util.PriorityQueue;

public class MinimumCostConnectSticks {
    public static void main(String[] args) {
        int[] arr = {1,3,11,5};
        System.out.println(connectSticks(arr));
    }

    public static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i< sticks.length; i++)
        {
            minHeap.add(sticks[i]);
        }

        int result = 0;

        // temp shld be loaded into maxheap
        while (minHeap.size() > 1)
        {
            int temp = minHeap.poll() + minHeap.poll();
            result += temp;
            minHeap.add(temp);
        }

        return result;
    }
}
