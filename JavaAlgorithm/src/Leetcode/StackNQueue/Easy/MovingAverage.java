package Leetcode.String.Easy.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    int maxSize;
    Queue<Integer> queue;
    double sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        maxSize = size;
        sum = 0.0;
    }

    public double next(int val) {
        if (queue.size() == maxSize)
        {
            sum -= queue.poll();
        }
        queue.add(val);
        sum += val;
        return sum/queue.size();
    }
}
