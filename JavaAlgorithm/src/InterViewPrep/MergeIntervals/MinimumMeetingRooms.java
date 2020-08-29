/*
Meetings: [[1,4], [2,5], [7,9]]
Output: 2
Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
occur in any of the two rooms later.

* */
package InterViewPrep.MergeIntervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {
    static class Element {
        int start;
        int end;

        public Element(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,4}, {2,5}, {7,9}};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[][] arr)
    {
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a,b) -> a.start - b.start);
        int maxRooms = 0;

        List<Element> list = new ArrayList<>();
        for (int[] item: arr
        ) {
            list.add(new Element(item[0], item[1]));
        }

        for (int i = 0; i < list.size(); i++) {
            while (!minHeap.isEmpty() && list.get(i).start >= minHeap.peek().end)
            {
                minHeap.poll();
            }

            minHeap.add(list.get(i));

            maxRooms = Math.max(maxRooms, minHeap.size());
        }

        return maxRooms;
    }
}
