package InterViewPrep.TopKNumbers;

import java.util.*;

public class RearrangeString {
    public static void main(String[] args) {
        String str = "aappp";
        System.out.println(Calculate(str));
    }

    private static String Calculate(String str)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: str.toCharArray()
        ) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        Map.Entry<Character, Integer> previous = null;
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty())
        {
            Map.Entry<Character, Integer> polled = maxHeap.poll();
            result.append(polled.getKey());
            polled.setValue(polled.getValue()-1);
            if(previous != null && previous.getValue() > 0)
            {
                maxHeap.add(previous);
            }
            previous = polled;
        }

        return result.toString();
    }
}
