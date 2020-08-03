/*
1. declare interval class
2. store maxstart and maxend heaps.
3. loop till N(length of arr). Get the topend from maxEndHeap
   Get the topstart when  maxStartHeap.peek.start >= topEnd.end
   store in result array at topEnd location
* */
package Leetcode.TwoHeaps.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NextInterval {
    static class Interval
    {
        public int start;
        public int end;
        public int arrayIdx;

        public Interval(int start, int end, int arrayIdx) {
            this.start = start;
            this.end = end;
            this.arrayIdx = arrayIdx;
        }
        public String toString()
        {
            return start + ", " + end;
        }
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(2,3, 0));
        list.add(new Interval(3,4, 1));
        list.add(new Interval(5,6, 2));

        Arrays.stream(Calculate(list)).forEach(System.out::println);
    }

    private static int[] Calculate(List<Interval> intervals) {
        PriorityQueue<Interval> maxStartheap = new PriorityQueue<>((a,b) -> b.start - a.start);
        PriorityQueue<Interval> maxEndheap = new PriorityQueue<>((a,b) -> b.end - a.end);

        int[] result = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            maxStartheap.add(intervals.get(i));
            maxEndheap.add(intervals.get(i));
        }

        while (!maxEndheap.isEmpty()) {
            Interval topEnd = maxEndheap.poll();
            result[topEnd.arrayIdx] = -1;

            if (!maxStartheap.isEmpty() && maxStartheap.peek().start >= topEnd.end)
            {
                Interval topStart = maxStartheap.poll();

                // this is to remove extra intervals
                while (!maxStartheap.isEmpty() && maxStartheap.peek().start >= topEnd.end)
                {
                    topStart = maxStartheap.poll();
                }
                result[topEnd.arrayIdx] = topStart.arrayIdx;
                maxStartheap.add(topStart);
            }
        }

        return result;
    }
}
