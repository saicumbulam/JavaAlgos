package Leetcode.Medium;

import java.util.PriorityQueue;

public class FindKthLargestInArray {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
        }

        while (k > 1)
        {
            maxHeap.poll();
            k--;
        }
        System.out.println(maxHeap.peek());
    }
}
