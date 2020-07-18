package Leetcode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NextInterval {
    static class Interval
    {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(2,3));
        list.add(new Interval(3,4));
        list.add(new Interval(5,6));

        Arrays.stream(Calculate(list)).forEach(System.out::println);
    }

    private static int[] Calculate(List<Interval> intervals) {
        PriorityQueue<Integer> maxStartheap = new PriorityQueue<>((a,b) -> intervals.get(b).start - intervals.get(a).start);
        PriorityQueue<Integer> maxEndheap = new PriorityQueue<>((a,b) -> intervals.get(b).end - intervals.get(a).end);

        int[] result = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            maxStartheap.add(i);
            maxEndheap.add(i);
        }

        for (int i = 0; i < intervals.size(); i++) {
            int topEnd = maxEndheap.poll();
            result[topEnd] = -1;
            if (intervals.get(maxStartheap.peek()).start >= intervals.get(topEnd).end)
            {
                int topStart = maxStartheap.poll();

                while (!maxStartheap.isEmpty() && intervals.get(maxStartheap.peek()).start >= intervals.get(topEnd).end)
                {
                    topStart = maxStartheap.poll();
                }
                result[topEnd] = topStart;
                maxStartheap.add(topStart);
            }
        }

        return result;
    }
}
