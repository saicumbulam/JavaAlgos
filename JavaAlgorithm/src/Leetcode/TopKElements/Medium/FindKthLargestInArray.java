package Leetcode.TopKElements.Medium;

import java.util.PriorityQueue;

public class FindKthLargestInArray {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k)
            {
                minHeap.poll();
            }
        }

        System.out.println(minHeap.peek());
    }
}
