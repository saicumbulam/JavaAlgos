/*
Input: "mmpp", K=2
Output: "mpmp" or "pmpm"
Explanation: All same characters are 2 distance apart.
* */
package InterViewPrep.TopKNumbers;

import java.util.*;

public class RearrangeStringKDistanceApart {
    public static void main(String[] args) {
        String str = "mmpp";
        int k=2;
        System.out.println(Calculate(str, k));
    }

    private static String Calculate(String str, int k)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: str.toCharArray()
             ) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty())
        {
            Map.Entry<Character, Integer> polled = maxHeap.poll();
            result.append(polled.getKey());
            polled.setValue(polled.getValue()-1);
            queue.add(polled);
            while (queue.size() >= k)
            {
                if (queue.peek().getValue() > 0)
                {
                    maxHeap.add(queue.poll());
                }
                else
                {
                    queue.poll();
                }
            }
        }

        return result.toString();
    }
}
