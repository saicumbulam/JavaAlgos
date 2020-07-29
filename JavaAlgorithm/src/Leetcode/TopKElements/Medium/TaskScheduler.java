/*
Time complexity : o(nlogn)
Space complexity: o(n)
* */
package Leetcode.Medium;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] arr = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval(arr, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        int intervalCount = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: tasks)
        {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        while(!maxHeap.isEmpty())
        {
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            int k = n+1;

            for (; k > 0 && !maxHeap.isEmpty();k--)
            {
                //increment the interval count
                intervalCount++;
                Map.Entry<Character, Integer> polled = maxHeap.poll();
                if (polled.getValue() > 1)
                {
                    polled.setValue(polled.getValue() - 1);
                    waitList.add(polled);
                }
            }

            maxHeap.addAll(waitList);
            if(!maxHeap.isEmpty())
            {
                intervalCount += k;
            }
        }
        return intervalCount;
    }
}
