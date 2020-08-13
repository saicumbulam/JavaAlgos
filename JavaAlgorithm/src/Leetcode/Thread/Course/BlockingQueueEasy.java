package Leetcode.Thread.Course;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueueEasy {
    Queue<Integer> queue = new LinkedList<>();
    int limit = 10;

    public BlockingQueueEasy(int limit) {
        this.limit = limit;
    }

    public synchronized void Enqueue(int value) throws InterruptedException {
        while (this.queue.size() == this.limit)
        {
            wait();
        }

        if (this.queue.size() == 0)
        {
            notifyAll();
        }

        this.queue.add(value);
    }
    public synchronized void Dequeue(int value) throws InterruptedException {
        while (this.queue.size() == 0)
        {
            wait();
        }

        if (this.queue.size() == this.limit)
        {
            notifyAll();
        }

        this.queue.poll();
    }

}
