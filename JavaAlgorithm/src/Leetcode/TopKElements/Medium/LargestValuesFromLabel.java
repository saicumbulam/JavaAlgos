/*
Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
Output: 9
Explanation: The subset chosen is the first, third, and fifth item.

1. Create a Item class and store all values in a list
2. Add items in a maxheap queue.
3. poll items in a queue and increment the sum with the value.
* */
package Leetcode.TopKElements.Medium;

import java.util.*;

public class LargestValuesFromLabel {
    public static void main(String[] args) {
        int[] values = new int[]{5,4,3,2,1};
        int[] labels = new int[]{1,1,2,2,3};
        int numWanted = 3;
        int useLimit = 1;
        System.out.println(Calculate(values, labels, numWanted, useLimit));
    }

    private static int Calculate(int[] values, int[] labels, int numWanted, int useLimit)
    {
        PriorityQueue<Item> maxHeap = new PriorityQueue<>((a,b) -> b.value - a.value);
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            list.add(new Item(values[i], labels[i]));
        }

        maxHeap.addAll(list);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;

        while (!maxHeap.isEmpty() && numWanted > 0)
        {
            Item item = maxHeap.poll();
            hashMap.put(item.label, hashMap.getOrDefault(item.label, 0)+1);
            if(hashMap.get(item.label) <= useLimit)
            {
                sum += item.value;
                numWanted--;
            }
        }
        return sum;
    }

    static class Item
    {
        int value;
        int label;

        public Item(int value, int label)
        {
            this.value = value;
            this.label = label;
        }
    }
}
