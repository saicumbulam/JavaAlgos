package Leetcode.Medium;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] arr = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent(arr, 2));
    }

    static class Element
    {
        String element;
        int frequency;

        public Element(String element, int freq)
        {
            this.element = element;
            this.frequency = freq;
        }
    }

    static class ElementCompare implements Comparator<Element>
    {
        public int compare(Element e1, Element e2)
        {
            if (e1.frequency != e2.frequency)
            {
                return e2.frequency - e1.frequency;
            }
            return e1.element.compareTo(e2.element);
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Element> maxHeap = new PriorityQueue<>(new ElementCompare());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++)
        {
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        }

        List<Element> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet())
        {
            list.add(new Element(entry.getKey(), entry.getValue()));
        }

        maxHeap.addAll(list);
        List<String> result = new ArrayList<>();

        while (!maxHeap.isEmpty() && k > 0)
        {
            Element polled = maxHeap.poll();
            result.add(polled.element);
            k--;
        }

        return result;
    }
}
