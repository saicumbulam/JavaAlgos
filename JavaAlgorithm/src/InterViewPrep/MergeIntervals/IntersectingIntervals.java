/*

Find the intersection of these two lists. Each list consists
of disjoint intervals sorted on their start time.

Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
Output: [2, 3], [5, 6], [7, 7]
Explanation: The output list contains the common intervals between the two lists.


* */
package InterViewPrep.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class IntersectingIntervals {
    public static void main(String[] args) {
        //int[][] arr1 = {{1, 3}, {5, 6}, {7, 9}};
        int[][] arr1 = {{1, 3}, {5, 7}, {9, 12}};
        //int[][] arr2={{2, 3}, {5, 7}};
        int[][] arr2={{5, 10}};

        System.out.println(Calculate(arr1, arr2));
    }

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

    private static List<Element> Calculate(int[][] arr1, int[][] arr2)
    {
        int i1 = 0, i2 = 0;
        List<Element> list1 = new ArrayList<>();
        List<Element> list2 = new ArrayList<>();

        for (int[] item: arr1
        ) {
            list1.add(new Element(item[0], item[1]));
        }

        for (int[] item: arr2
        ) {
            list2.add(new Element(item[0], item[1]));
        }
        List<Element> intersect = new ArrayList<>();

        //arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
        //[2, 3], [5, 6], [7, 7]
        while (i1 < list1.size() && i2 < list2.size())
        {
            if ((list1.get(i1).start <= list2.get(i2).start && list1.get(i1).end >= list2.get(i2).start)
                    ||
                    (list1.get(i1).start >= list2.get(i2).start && list1.get(i1).start <= list2.get(i2).end))
            {
                intersect.add(new Element(Math.max(list1.get(i1).start,list2.get(i2).start),
                        Math.min(list1.get(i1).end,list2.get(i2).end)));
            }
            if (list1.get(i1).end < list2.get(i2).end)
            {
                i1++;
            }
            else {
                i2++;
            }
        }
        return intersect;
    }
}
