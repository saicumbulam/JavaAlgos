package Leetcode.TwoHeaps.Hard;

import java.util.PriorityQueue;

public class SlidingWindowMedian {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

    public static void main(String[] args) {
        int[] arr = {1,2,-1,3,5};
        int target = 2;
        for (double item:Calculate(arr,target))
        {
            System.out.println(item);
        }
    }

    private static double[] Calculate(int[] arr, int target) {
        double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= arr[i])
            {
                maxHeap.add(arr[i]);
            }
            else
            {
                minHeap.add(arr[i]);
            }
            rebalanceHeap();

            if (i - target + 1 >= 0)
            {
                if (maxHeap.size() == minHeap.size())
                {
                    result[i-target+1] = maxHeap.peek()/2.0 + minHeap.peek()/2.0;
                }
                else
                {
                    result[i-target+1] = maxHeap.peek();
                }

                int elementTobeRemoved = arr[i-target+1];
                if (maxHeap.peek() >= elementTobeRemoved)
                {
                    maxHeap.remove(elementTobeRemoved);
                }
                else
                {
                    minHeap.remove(elementTobeRemoved);
                }
                rebalanceHeap();
            }
        }
        return result;
    }

    private static void rebalanceHeap() {
        if (maxHeap.size() > minHeap.size()+1)
        {
            minHeap.add(maxHeap.poll());
        }
        else if (minHeap.size() > maxHeap.size())
        {
            maxHeap.add(minHeap.poll());
        }
    }


}
