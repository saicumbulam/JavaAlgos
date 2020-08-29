/*
Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
one [1,5].

Time complexity: O(N)
space complexity: O(N)
* */
package InterViewPrep.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
    static class Element
    {
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

    private static List<Element> Calculate(int[][] arr)
    {
        List<Element> result = new ArrayList<>();
        List<Element> output = new ArrayList<>();
        for (int[] item: arr
             ) {
            result.add(new Element(item[0], item[1]));
        }

        Collections.sort(result, (a, b) -> a.start - b.start);

        int start = result.get(0).start;
        int end = result.get(0).end;

        for (int i = 1; i < result.size(); i++) {
            if (end >= result.get(i).start)
            {
                end = Math.max(result.get(i).end, end);
            }
            else
            {
                output.add(new Element(start, end));
                start = result.get(i).start;
                end = result.get(i).end;
            }
        }

        output.add(new Element(start, end));

        return output;
    }
}
