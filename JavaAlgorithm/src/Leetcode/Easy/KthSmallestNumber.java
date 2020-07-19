package Leetcode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestNumber {
    public static void main(String[] args) {
        int[] arr = {3,1,5,12,2,11};
        int k = 3;
        System.out.println(Calculate(arr,k));
    }

    private static int Calculate(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        for (int item: arr
        ) {
            maxHeap.add(item);
            if (maxHeap.size() > k)
            {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }
}
