package Leetcode.Easy;

import java.util.PriorityQueue;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] results = new int[heights.length];

        for(int i = 0; i < heights.length; i++)
        {
            minHeap.add(heights[i]);
        }

        for(int i = 0; i < results.length; i++)
        {
            results[i] = minHeap.poll();
        }

        int count = 0;

        for(int i = 0; i < heights.length; i++)
        {
            if (heights[i] != results[i])
            {
                count++;
            }
        }

        return count;
    }
}
