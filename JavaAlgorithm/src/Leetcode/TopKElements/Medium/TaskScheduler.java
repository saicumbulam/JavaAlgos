/*
Time complexity : o(nlogn)
Space complexity: o(n)
* */
package Leetcode.Medium;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        //char[] arr = {'A','A','A','B','B','B'};
        //int n = 2;

        char[] arr = {'A','A','A','B','B','B'};
        int n = 0;
        System.out.println(leastInterval(arr, n));
    }

    public static int leastInterval(char[] tasks, int k) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char item: tasks
             ) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        int intervalCount = 0;

        while (!maxHeap.isEmpty())
        {
            int n = k+1;
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            for (; !maxHeap.isEmpty() && n > 0;n--)
            {
                intervalCount++;
                Map.Entry<Character, Integer> item = maxHeap.poll();
                item.setValue(item.getValue()-1);
                if (item.getValue() > 0)
                {
                    waitList.add(item);
                }
            }

            maxHeap.addAll(waitList);
            if (!maxHeap.isEmpty())
            {
                intervalCount += n;
            }
        }

        return intervalCount;
    }
}
