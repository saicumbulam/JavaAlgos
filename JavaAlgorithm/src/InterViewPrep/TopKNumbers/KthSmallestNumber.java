/*
Input: [1, 5, 12, 2, 11, 5], K = 3
Output: 5
Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2].

Time complexity : O(K LOGN)
Space: O(K)
* */
package InterViewPrep.TopKNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestNumber {
    public static void main(String[] args) {
        int[] arr = {1, 5, 12, 2, 11, 5};
        int k = 3;
        System.out.println(Calculate(arr, k));
    }

    private static int Calculate(int[] arr, int k)
    {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int item: arr
        ) {
            minHeap.add(item);

            if (minHeap.size() > k)
            {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
