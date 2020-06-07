package Leetcode.Medium;

import java.util.*;

public class MergeIntervals {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString()
        {
            return "[" + start + "," + end + "]";
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1,4},{4,5}};

        List<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            intervals.add(new Interval(nums[i][0], nums[i][1]));
        }

        System.out.println(Calculate(intervals));
    }

    private static List<Interval> Calculate(List<Interval>
                                                    intervals)
    {
        List<Interval> mergedInterval = new ArrayList<>();

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size() ; i++) {
            if (intervals.get(i).start <= end)
            {
                end = Math.max(end, intervals.get(i).end);
            }
            else
            {
                mergedInterval.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }

        mergedInterval.add(new Interval(start, end));

        return mergedInterval;
    }
}
