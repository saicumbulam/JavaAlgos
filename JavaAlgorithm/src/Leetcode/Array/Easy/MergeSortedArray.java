package Leetcode.String.Easy.Easy;

import java.util.PriorityQueue;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            minHeap.add(nums1[i]);
        }

        for (int i = 0; i < n; i++) {
            minHeap.add(nums2[i]);
        }

        int index = 0;
        while (!minHeap.isEmpty()) {
            nums1[index] = minHeap.poll();
            index++;
        }

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
