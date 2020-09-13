/*
Time complexity is o(n)
* */

package Leetcode.String.Easy.Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElementsQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        Calculate(queue, 3);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    private static void Calculate(Queue<Integer> queue, int k)
    {
        Stack<Integer> stack = new Stack<>();
        int capacity = k;

        while (capacity > 0)
        {
            stack.push(queue.poll());
            capacity--;
        }

        while (!stack.isEmpty())
        {
            queue.add(stack.pop());
        }

        int skip = queue.size() - k;
        for (int i = 0; i < skip; i++) {
            queue.add(queue.poll());
        }
    }
}
