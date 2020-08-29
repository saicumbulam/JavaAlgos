package InterViewPrep.TopKNumbers;

import java.util.*;

public class MaximumDistinctNumbers {
    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 8, 5, 3, 3};
        //int[] arr = {3, 5, 12, 11, 12};
        //int[] arr = {1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5};
        int k=2;
        //int k=3;
        //int k=2;
        System.out.println(Calculate(arr, k));
    }

    private static List<Integer> Calculate(int[] arr, int k)
    {
        List<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item: arr
             ) {
            map.put(item, map.getOrDefault(item,0) +1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new
                PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer,Integer> item: map.entrySet()
             ) {
            minHeap.add(item);
        }

        int count = k;
        while (!minHeap.isEmpty() && k > 0)
        {
            Map.Entry<Integer,Integer> item = minHeap.poll();
            if (item.getValue() == 1)
            {
                result.add(item.getKey());
            }
            else
            {
                item.setValue(item.getValue()-1);
                minHeap.add(item);
                k--;
            }
        }

        while (k > 0)
        {
            result = result.subList(1, result.size());
            k--;
        }

        return result;
    }
}
