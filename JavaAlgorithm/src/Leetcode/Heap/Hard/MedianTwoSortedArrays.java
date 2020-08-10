package Leetcode.Heap.Hard;

import java.util.PriorityQueue;

public class MedianTwoSortedArrays {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        Calculate(nums1, nums2);
        System.out.println(GetMedian());
    }

    private static void Calculate(int[] nums1, int[] nums2)
    {
        for(int num: nums1)
        {
            Add(num);
        }

        for (int num: nums2
             ) {
            Add(num);
        }
    }

    private static void Add(int num)
    {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num)
        {
            maxHeap.add(num);
        }
        else
        {
            minHeap.add(num);
        }

        if (maxHeap.size() >= minHeap.size()+1)
        {
            minHeap.add(maxHeap.poll());
        }
        else if (maxHeap.size() < minHeap.size())
        {
            maxHeap.add(minHeap.poll());
        }
    }

    private static double GetMedian()
    {
        if (maxHeap.size() == minHeap.size())
        {
            return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
        }
        else
        {
            return maxHeap.peek();
        }
    }
}
