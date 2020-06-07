package Leetcode.Hard;

import java.util.PriorityQueue;

public class FindMedianOfDataStream {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

    public static void main(String[] args) {
        int[] nums = {2,3,4};
        for (int i = 0; i < nums.length; i++) {
            Add(nums[i]);
        }
        System.out.println(GetMedian());
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
