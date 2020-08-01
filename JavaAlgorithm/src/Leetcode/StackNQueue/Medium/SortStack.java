/*
Time complexity : o(n^2)
* */
package Leetcode.StackNQueue.Medium;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
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
            if (newStack.isEmpty() || stack.peek() > newStack.peek())
            {
                newStack.push(stack.pop());
            }
            else {
                while (!newStack.isEmpty() && stack.peek() < newStack.peek())
                {
                    stack.push(newStack.pop());
                }
            }
        }

        while (!newStack.isEmpty())
        {
            stack.push(newStack.pop());
        }
    }
}
