package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeetingScheduler {
    public static void main(String[] args) {
        int[][] slots1 = {{10,50}, {60,120}, {140, 210}};
        int[][] slots2 = {{0,15}, {60,70}};
        int duration = 8;

        System.out.println(Calculate(slots1, slots2, duration));
    }

    static class Interval
    {
        int start;
        int end;

        public Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    private static List<Integer> Calculate(int[][] slots1 , int[][] slots2, int duration)
    {
        List<Interval> slots1List = new ArrayList<>();
        for (int i = 0; i < slots1.length; i++) {
            slots1List.add(new Interval(slots1[i][0], slots2[i][1]));
        }

        List<Interval> slots2List = new ArrayList<>();
        for (int i = 0; i < slots2.length; i++) {
            slots2List.add(new Interval(slots2[i][0], slots2[i][1]));
        }

        Collections.sort(slots1List, (a,b) -> a.start - b.start);
        Collections.sort(slots2List, (a,b) -> a.start - b.start);

        int i = 0, j = 0;

        while (i < slots1List.size() && j < slots2List.size())
        {
            Interval first = slots1List.get(i);
            Interval second = slots2List.get(j);

            if ((first.end >= second.start && first.end <= second.end) ||
                    (second.end >= first.start && second.end <= first.end))
            {
                 int start = Math.max(first.start, second.start);
                 int end = Math.min(first.end, second.end);
                 if (duration >= (end - start))
                 {
                     List<Integer> result = new ArrayList<>(Arrays.asList(start, start+duration));
                     return result;
                 }
            }

            if (first.start >= second.start)
            {
                i++;
            }
            else
            {
                j++;
            }
        }

        return new ArrayList<>();

    }

}
