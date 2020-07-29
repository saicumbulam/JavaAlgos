package Leetcode.Medium;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsOrigin {
    static class Point
    {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int toDistance()
        {
            return (x * x) + (y*y);
        }

        @Override
        public String toString()
        {
            return "[" + x + "," + y + "]";
        }
    }
    public static void main(String[] args) {
        int[][] nums = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        System.out.println(Calculate(nums, k));
    }

    private static List<Point> Calculate(int[][] nums, int k)
    {
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>((a,b) -> b.toDistance() - a.toDistance());

        for (int i = 0; i < nums.length; i++) {
            Point p = new Point(nums[i][0], nums[i][1]);
            maxHeap.add(p);
            if (maxHeap.size() > k)
            {
                maxHeap.poll();
            }
        }

        List<Point> newList = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            newList.add(maxHeap.poll());
        }
        return newList;
    }
}
