package Leetcode.String.Easy.Easy;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        MiniStack stack = new MiniStack();
        stack.add(-2);
        stack.add(0);
        stack.add(-3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
    }
}

class MiniStack
{
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> mini = new Stack<>();

    public boolean isEmpty()
    {
        return stack.size() == 0;
    }
    public void add(int value)
    {
        if(isEmpty())
        {
            stack.push(value);
            mini.push(value);
        }
        else
        {
            stack.push(value);
            if(mini.peek() < value)
            {
                mini.push(mini.peek());
            }
            else
            {
                mini.push(value);
            }
        }
    }

    public int pop()
    {
        if(isEmpty())
        {
            return -1;
        }
        mini.pop();
        return stack.pop();
    }
    public int peek()
    {
        if(isEmpty())
        {
            return -1;
        }
        return stack.peek();
    }

    public int min(){
        if (isEmpty())
        {
            return -1;
        }
        return mini.peek();
    }
}
