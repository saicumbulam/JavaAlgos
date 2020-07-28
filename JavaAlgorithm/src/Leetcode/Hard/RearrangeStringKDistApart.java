/*
Time complexity: o(nlogn)
Space complexity: o(n)

pseudo code:
1. Get frequency of the characters in string
2. Load the freq into a maxHeap.
3. poll the maxheap in a loop and add it to the queue and result.  decrease the freq of element
4. when queue is k size, remove the element and load in maxHeap again.

* */
package Leetcode.Hard;

import java.util.*;

public class RearrangeStringKDistApart {
    public static void main(String[] args) {
        String str = "aabbcc";
        int k = 3;
        System.out.println(rearrangeString(str, k));
    }

    public static String rearrangeString(String s, int k) {
        if (k <= 1)
        {
            return s;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        StringBuilder result = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

        while (!maxHeap.isEmpty())
        {
            Map.Entry<Character, Integer> polled = maxHeap.poll();
            result.append(polled.getKey());
            polled.setValue(polled.getValue() - 1);
            queue.add(polled);

            if (queue.size() == k)
            {
                Map.Entry<Character, Integer> entry = queue.poll();
                // should be greater than 0, to include all the elements
                if (entry.getValue() > 0)
                {
                    maxHeap.add(entry);
                }
            }
        }

        return result.length() == s.length() ? result.toString(): "";
    }
}
