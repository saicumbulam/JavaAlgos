package Leetcode.Easy;

import java.util.Stack;

public class MaxStack {
    public static void main(String[] args) {
        MaxiStack stack = new MaxiStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        System.out.println(stack.top());
        System.out.println(stack.popMax());
        System.out.println(stack.top());
        System.out.println(stack.peekMax());
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}

class MaxiStack
{
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> maxi = new Stack<>();

    public boolean isEmpty()
    {
        return stack.size() == 0;
    }

    public void push(int value)
    {
        if(isEmpty())
        {
            stack.push(value);
            maxi.push(value);
        }
        else
        {
            stack.push(value);
            if(maxi.peek() > value)
            {
                maxi.push(maxi.peek());
            }
            else
            {
                maxi.push(value);
            }
        }
    }

    public int popMax()
    {
        int maximum = peekMax();
        Stack<Integer> buffer = new Stack();

        while (maximum != top())
        {
            buffer.push(pop());
        }
        pop(); // remove maximum element

        while (!buffer.isEmpty())
        {
            push(buffer.pop());
        }

        return maximum;
    }

    public int pop()
    {
        if(isEmpty())
        {
            return -1;
        }
        maxi.pop();
        return stack.pop();
    }
    public int top()
    {
        if(isEmpty())
        {
            return -1;
        }
        return stack.peek();
    }

    public int peekMax(){
        if (isEmpty())
        {
            return -1;
        }
        return maxi.peek();
    }
}
