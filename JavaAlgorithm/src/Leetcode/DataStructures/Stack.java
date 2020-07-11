package Leetcode.DataStructures;

public class Stack {
    private int maxSize;
    private int top;
    private int[] array;
    private int size;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        array = new int[maxSize];
        size = 0;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty()
    {
        return top == -1;
    }

    public boolean isFull()
    {
        return size == maxSize-1;
    }

    public int top() {
        if (isEmpty())
            return -1;
        return array[top];
    }

    public void push(int value) {
        if (isFull()) {
            System.err.println("Stack is Full!");
            return;
        }
        array[++top] = value; //increments the top and adds value to updated top
        size++;
    }

    public int pop() {
        if (isEmpty())
            return -1;
        size--;
        return array[top--]; //returns value and top and decrements the top
    }
}
