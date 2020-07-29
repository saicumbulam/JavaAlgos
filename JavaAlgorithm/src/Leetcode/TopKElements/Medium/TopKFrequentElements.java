package Leetcode.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int k = 2;
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int item: arr
             ) {
            hashMap.put(item, hashMap.getOrDefault(item, 0)+1);
        }

        maxHeap.addAll(hashMap.entrySet());
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            System.out.println(maxHeap.poll().getKey());
        }

    }
}
