/*
1. top1 , top2 = -1
2. push: top1 < top2-1 => arr[++top1], arr[top2--]
3. pop: top1 > -1, top2 < maxSize => arr[top1--], arr[top2++]
* */
package Leetcode.StackNQueue.Easy;

public class ImplementTwoStacksArray {
    private int maxSize;
    private int top1, top2;
    private int[] arr;

    public ImplementTwoStacksArray(int size)
    {
        maxSize = size;
        top1 = -1;
        top2 = maxSize;
        arr = new int[maxSize];
    }

    public void push1(int x)
    {
        if(top1 < top2-1)
        {
            arr[++top1] = x;
        }
    }

    public void push2(int x)
    {
        if(top1 < top2-1)
        {
            arr[top1--] = x;
        }
    }

    public int pop1()
    {
        if (top1 > -1)
        {
            return arr[maxSize--];
        }
        return -1;
    }

    public int pop2()
    {
        if(top2 < maxSize)
        {
            return arr[maxSize++];
        }
        return -1;
    }
}
