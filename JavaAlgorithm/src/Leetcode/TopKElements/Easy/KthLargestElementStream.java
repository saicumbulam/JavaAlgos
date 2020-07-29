package Leetcode.String.Easy.Easy;

import java.util.PriorityQueue;

public class KthLargestElementStream {
    public static void main(String[] args) {

    }

    static int k;
    static PriorityQueue<Integer> minHeap;

    private static void KthLargest(int val, int[] nums) {
        minHeap = new PriorityQueue<>();
        k = val;

        for (int i = 0; i< nums.length; i++)
        {
            minHeap.add(nums[i]);
        }
    }

    public static int add(int val) {
        minHeap.add(val);

        while (minHeap.size() > k)
        {
            minHeap.poll();
        }


        int temp = minHeap.peek();
        return temp;
    }
}
