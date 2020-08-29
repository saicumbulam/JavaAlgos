/*
Jobs: [[1,4,3], [2,5,4], [7,9,6]]
Output: 7
Explanation: Since [1,4,3] and [2,5,4] overlap,
their maximum CPU load (3+4=7) will be when both the
jobs are running at the same time i.e., during the time interval (2,4).

* */
package InterViewPrep.MergeIntervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumCPUOverload {
    static class Element {
        int start;
        int end;
        int cpu;

        public Element(int start, int end, int cpu) {
            this.start = start;
            this.end = end;
            this.cpu = cpu;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "start=" + start +
                    ", end=" + end +
                    ", cpu=" + cpu +
                    '}';
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{1,4,3}, {2,5,4}, {7,9,6}};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[][] arr)
    {
        PriorityQueue<Element> minHeap = new
                PriorityQueue<>((a, b) -> a.start - b.start);
        int maxCPU = 0;
        int curCPU = 0;

        List<Element> list = new ArrayList<>();
        for (int[] item: arr
        ) {
            list.add(new Element(item[0], item[1], item[2]));
        }

        for (int i = 0; i < list.size(); i++) {
            while (!minHeap.isEmpty() && list.get(i).start >= minHeap.peek().end)
            {
                curCPU -= minHeap.poll().cpu;
            }

            minHeap.add(list.get(i));
            curCPU += list.get(i).cpu;

            maxCPU = Math.max(maxCPU, curCPU);
        }

        return maxCPU;
    }
}
