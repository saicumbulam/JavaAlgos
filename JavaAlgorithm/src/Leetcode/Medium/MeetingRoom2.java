package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoom2 {
    public static void main(String[] args) {
        int[][] nums = {{0, 30},{5, 10},{15, 20}};
        System.out.println(Calculate(nums));
    }

    static class Interval
    {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString()
        {
            return "[" + start + "," + end + "]";
        }
    }

    private static int Calculate(int[][] nums)
    {
        List<Interval> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(new Interval(nums[i][0], nums[i][1]));
        }

        Collections.sort(list, (a,b) -> a.start - b.start);

        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b) -> a.end - b.end);

        int meetingRooms = 0;

        for (int i = 0; i < list.size(); i++) {
            if(!minHeap.isEmpty() && minHeap.peek().end <= list.get(i).start)
            {
                minHeap.poll();
            }

            minHeap.add(list.get(i));

            meetingRooms = Math.max(meetingRooms,minHeap.size());
        }
        return meetingRooms;
    }
}
