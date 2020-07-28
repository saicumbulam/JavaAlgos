/*
Time complexity: o(nlogn)
Space complexity: o(n)

pseudo code:
1. load numbers into minHeap.
2. poll numbers less than < k1.
3. Add numbers from by polling from k2-k1-1.

* */
package Leetcode.Medium;

import java.util.PriorityQueue;

public class SumNumbersBetweenK1andK2 {
    public static void main(String[] args) {
        int[] arr = {1,3,12,5,15,11};
        int k1 = 3;
        int k2 = 6;
        System.out.println(findSumOfElements(arr, k1, k2));
    }

    private static int findSumOfElements(int[] num, int k1, int k2)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < num.length; i++) {
            minHeap.add(num[i]);
        }

        for (int i = 0; i < k1; i++) {
            minHeap.poll();
        }

        int sum = 0;
        for (int i = 0; i < k2-k1-1; i++) {
            sum += minHeap.poll();
        }

        return sum;
    }
}
