/*
1. Maintain current Max number
2. Update the range start and range end by using polling and adding minheap.
* */
package Leetcode.KWayMerge.Medium;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MSortedArraysFindSmallestRange {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,5,8));
        list.add(Arrays.asList(4,12));
        list.add(Arrays.asList(7,8,10));
        System.out.println(Calculate(list));
    }

    static class Element
    {
        int arrayIdx;
        int elmtIdx;

        public Element(int arrayIdx, int elmtIdx)
        {
            this.arrayIdx = arrayIdx;
            this.elmtIdx = elmtIdx;
        }
    }

    private static List<Integer> Calculate(List<List<Integer>> list)
    {
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a,b) -> list.get(a.arrayIdx).get(a.elmtIdx)
         - list.get(b.arrayIdx).get(b.elmtIdx));

        int currentMax = 0;
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {
            minHeap.add(new Element(i, 0));
            currentMax = Math.max(currentMax, list.get(i).get(0));
        }

        // The size comparison is nessacary to get ranges between the number
        while (minHeap.size() == list.size())
        {
            Element polled = minHeap.poll();
            if (rangeEnd - rangeStart > currentMax - list.get(polled.arrayIdx).get(polled.elmtIdx))
            {
                rangeStart = list.get(polled.arrayIdx).get(polled.elmtIdx);
                rangeEnd = currentMax;
            }

            if (polled.elmtIdx < list.get(polled.arrayIdx).size()-1)
            {
                minHeap.add(new Element(polled.arrayIdx, polled.elmtIdx+1));
                currentMax = Math.max(currentMax, list.get(polled.arrayIdx).get(polled.elmtIdx+1));
            }
        }

        return Arrays.asList(rangeStart, rangeEnd);
    }
}
