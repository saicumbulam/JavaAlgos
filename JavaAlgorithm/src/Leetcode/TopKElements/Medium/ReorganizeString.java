/*
Time complexity: o(nlogn)
Space complexity: o(n)

pseudo code:
1. Get frequency of the characters in string
2. Load the freq into a maxHeap.
3. poll the maxheap in a loop and add it to the result.  decrease the freq of element.
4. if  prevEntry != null and prevEntry.value > 0 , load it to maxHeap again. Assign the polled value to prevEntry.

* */
package Leetcode.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args) {
        String str = "aab";
        System.out.println(reorganizeString(str));
    }

    public static String reorganizeString(String S) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: S.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        Map.Entry<Character, Integer> previousEntry = null;
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty())
        {
            Map.Entry<Character, Integer> polled = maxHeap.poll();
            result.append(polled.getKey());
            if (previousEntry != null && previousEntry.getValue() > 0)
            {
                maxHeap.add(previousEntry);
            }
            polled.setValue(polled.getValue() - 1);
            previousEntry = polled;
        }

        return result.length() == S.length() ? result.toString(): "";
    }
}
