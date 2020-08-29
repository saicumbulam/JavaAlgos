/*
Time complexity : O(K LOGN)
Space: O(K)
* */
package InterViewPrep.TopKNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKNumbers {
    public static void main(String[] args) {
        int[] arr =  {3, 1, 5, 12, 2, 11};
        int k = 3;
        System.out.println(Calculate(arr, k));
    }

    private static List<Integer> Calculate(int[] arr, int k)
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

        while (!minHeap.isEmpty())
        {
            result.add(minHeap.poll());
        }

        return result;
    }
}
