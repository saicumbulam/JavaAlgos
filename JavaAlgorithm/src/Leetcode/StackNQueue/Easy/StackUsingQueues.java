/*
This has a swap queue to change from queue1 to queue2.
pop() => remove queue1
push(): if empty, queue1.add
        else queue2.add, while  !queue1.empty => queue2.add(queue1.poll)
        swapqueue
* */
package Leetcode.String.Easy.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();


    public void push(int x)
    {
        if(queue1.isEmpty())
        {
            queue1.add(x);
        }
        else
        {
            queue2.add(x);
            while (!queue1.isEmpty())
            {
                queue2.add(queue1.poll());
            }
            swapQueue();
        }
    }

    public int pop()
    {
        if(isEmpty())
        {
            return -1;
        }
        return queue1.remove();
    }

    public boolean isEmpty()
    {
        return queue1.size() + queue2.size() == 0;
    }

    public void swapQueue()
    {
        Queue<Integer> queue3 = queue1;
        queue1 = queue2;
        queue2 = queue3;
    }
}
