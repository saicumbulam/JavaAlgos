/*
Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
Output: [3,5]
Explanation: Both the employess are free between [3,5].

Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
Output: [4,6], [8,9]
Explanation: All employess are free between [4,6] and [8,9].


Input: Employee Working Hours=[[[1,3]], [[2,4]], [[3,5], [7,9]]]
Output: [5,7]
Explanation: All employess are free between [5,7].


Time complexity: O(NLOGN)
Space: O(N)
* */
package InterViewPrep.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {
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
        int[][] arr1 = {{1,3}, {5,6}};
        int[][] arr2 = {{2,3}, {6,8}};
        System.out.println(Calculate(arr1, arr2));
    }

    private static List<Element> Calculate(int[][] arr1, int[][] arr2)
    {
        List<Element> list = new ArrayList<>();
        List<Element> result = new ArrayList<>();

        for (int[] item: arr1
        ) {
            list.add(new Element(item[0], item[1]));
        }

        for (int[] item: arr2
        ) {
            list.add(new Element(item[0], item[1]));
        }

        Collections.sort(list, (a,b) -> a.start - b.start);

        int start = list.get(0).start;
        int end = list.get(0).end;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start <= end)
            {
                end = Math.max(end, list.get(i).end);
            }
            else
            {
                result.add(new Element(start, end));
                start = list.get(i).start;
                end = list.get(i).end;
            }
        }

        result.add(new Element(start, end));

        List<Element> result1 = new ArrayList<>();

        for (int i = 1; i < result.size(); i++) {
            result1.add(new Element(result.get(i-1).end, result.get(i).start));
        }

        return result1;
    }
}
