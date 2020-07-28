package Leetcode.Easy;

import java.util.PriorityQueue;

public class KthLargestElementStream {
    public static void main(String[] args) {

    }

    static int k;
    static PriorityQueue<Integer> maxHeap;

    private static void KthLargest(int val, int[] nums) {
        maxHeap = new PriorityQueue<>();
        k = val;

        for (int i = 0; i< nums.length; i++)
        {
            maxHeap.add(nums[i]);
        }
    }

    public static int add(int val) {
        maxHeap.add(val);

        while (maxHeap.size() > k)
        {
            maxHeap.poll();
        }


        int temp = maxHeap.peek();
        return temp;
    }
}
