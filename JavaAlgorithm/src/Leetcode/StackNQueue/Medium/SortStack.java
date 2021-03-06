/*
Time complexity : o(n^2)
* */
package Leetcode.StackNQueue.Medium;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        Calculate(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void Calculate(Stack<Integer> stack)
    {
        Stack<Integer> newStack = new Stack<>();

        while (!stack.isEmpty())
        {
            int value = stack.pop();

            while (!newStack.isEmpty() && newStack.peek() < value)
            {
                stack.push(newStack.pop());
            }
            newStack.push(value);
        }

        while (!newStack.isEmpty())
        {
            stack.push(newStack.pop());
        }
    }
}
