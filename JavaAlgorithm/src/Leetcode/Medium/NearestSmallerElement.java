package Leetcode.Medium;

import java.util.PriorityQueue;

public class NearestSmallerElement {
    public static void main(String[] args) {
        //int[] arr = {4, 5, 2, 10, 8};
        int[] arr = {3,2,1};
        for (int item: Calculate(arr)
             ) {
            System.out.println(item);
        }
    }

    private static int[] Calculate (int[] arr)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] result = new int[arr.length];
        result[0] = -1;
        minHeap.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (!minHeap.isEmpty() && minHeap.peek() < arr[i])
            {
                result[i] = minHeap.peek();
            }
            else
            {
                result[i] = -1;
            }
            minHeap.add(arr[i]);
        }

        return result;
    }
}
