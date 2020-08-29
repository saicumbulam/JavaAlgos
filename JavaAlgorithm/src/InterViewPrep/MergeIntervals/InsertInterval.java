/*
Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
Output: [[1,3], [4,7], [8,12]]
Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].

* */
package InterViewPrep.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertInterval {
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
        int[][] arr ={{1,3}, {5,7}, {8,12}};
        int[] newArr = {4,6};
        System.out.println(Calculate(arr, newArr));
    }

    private static List<Element> Calculate(int[][] arr, int[] newArr)
    {
        List<Element> result = new ArrayList<>();
        List<Element> output = new ArrayList<>();
        for (int[] item: arr
        ) {
            result.add(new Element(item[0], item[1]));
        }
        result.add(new Element(newArr[0], newArr[1]));

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
