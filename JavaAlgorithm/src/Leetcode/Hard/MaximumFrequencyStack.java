/*
Time complexity : o(logn)
space complexity : o(n)
* */
package Leetcode.Hard;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MaximumFrequencyStack {
    class Element
    {
        int val;
        int frequency;
        int sequenceNum;

        public Element(int val, int freq, int seq)
        {
            this.val = val;
            this.frequency = freq;
            this.sequenceNum = seq;
        }
    }

    class ElementComparator implements Comparator<Element>
    {
        public int compare(Element e1, Element e2)
        {
            if (e1.frequency != e2.frequency)
            {
                return e2.frequency - e1.frequency;
            }
            return e2.sequenceNum - e1.sequenceNum;
        }
    }

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    PriorityQueue<Element> maxHeap= new PriorityQueue<>(new ElementComparator());
    int sequenctNum = 0;

    public void push(int x) {
        hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        maxHeap.add(new Element(x, hashMap.get(x), sequenctNum++));
    }

    public int pop() {
        Element polled = maxHeap.poll();

        if (hashMap.containsKey(polled.val))
        {
            hashMap.put(polled.val, hashMap.get(polled.val) - 1);
            if (hashMap.get(polled.val) == 1)
            {
                hashMap.remove(polled.val);
            }
        }

        return polled.val;

    }
}
