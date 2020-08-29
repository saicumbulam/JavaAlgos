package InterViewPrep.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConflictingAppointments {
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
        //int[][] arr = {{1,4}, {2,5}, {7,9}};
        int[][] arr = {{6,7}, {2,4}, {8,12}};
        System.out.println(Calculate(arr));
    }

    private static boolean Calculate(int[][] arr)
    {
        List<Element> result = new ArrayList<>();
        for (int[] item: arr
        ) {
            result.add(new Element(item[0], item[1]));
        }

        Collections.sort(result, (a, b) -> a.start - b.start);


        int start = result.get(0).start;
        int end = result.get(0).end;

        for (int i = 1; i < result.size(); i++) {
            if (end >= result.get(i).start) {
                return false;
            } else {
                start = result.get(i).start;
                end = result.get(i).end;
            }
        }

        return true;
    }
}
