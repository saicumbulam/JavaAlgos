/*
1. for enqueue and push, use stack1
2. for dequeue, transfer all contents from stack1 to stack 2.
   return top element from stack2. transfer stack2 to stack1.
* */
package Leetcode.StackNQueue.Easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public ImplementQueueUsingStacks()
    {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public boolean isEmpty()
    {
        return stack1.isEmpty();
    }

    public void push(int x)
    {
        stack1.push(x);
    }

    public int dequeue()
    {
        while (!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }
        int temp = stack2.pop();

        while (!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }

        return temp;
    }


}
