/*
Time complexity is o(n)
* */

package Leetcode.Easy;

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
        Stack<Integer> stack = new Stack();

        while (stack.size() < k)
        {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty())
        {
            queue.add(stack.pop());
        }

        int size = queue.size() - k;
        for (int i = 0; i < size; i++) {
            queue.add(queue.poll());
        }
    }
}
