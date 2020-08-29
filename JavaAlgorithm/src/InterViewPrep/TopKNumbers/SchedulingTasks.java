/*
Input: [a, a, a, b, c, c], K=2
Output: 7
Explanation: a -> c -> b -> a -> c -> idle -> a

Time complexity: O(N LOGN)
Space: O(N)
* */
package InterViewPrep.TopKNumbers;

import java.util.*;

public class SchedulingTasks {
    public static void main(String[] args) {
        String [] arr = {"a", "a", "a", "b", "c", "c"};
        int k=2;
        System.out.println(Calculate(arr, k));
    }

    private static int Calculate(String[] arr, int k)
    {
        HashMap<String, Integer> map = new HashMap<>();
        for (String item: arr
             ) {
            map.put(item, map.getOrDefault(item, 0)+1);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new
                PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        int intervalCount = 0;

        maxHeap.addAll(map.entrySet());

        while (!maxHeap.isEmpty())
        {
            int n = k+1;
            List<Map.Entry<String, Integer>> waitList = new ArrayList<>();
            for (; !maxHeap.isEmpty() && n > 0 ; n--)
            {
                Map.Entry<String, Integer> polled = maxHeap.poll();
                intervalCount++;
                polled.setValue(polled.getValue()-1);
                if (polled.getValue() > 0)
                {
                    waitList.add(polled);
                }
            }

            maxHeap.addAll(waitList);
            if(!maxHeap.isEmpty())
            {
                intervalCount += n;
            }
        }

        return intervalCount;
    }
}
