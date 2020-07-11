package Leetcode.DataStructures;

public class Queue {
    private int maxSize;
    private int size;
    private int front;
    private int back;
    private int[] array;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        front = 0;
        back = -1;
        array = new int[maxSize];
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public boolean isFull()
    {
        return size == maxSize;
    }

    public void enqueue(int value)
    {
        if (isFull())
        {
            return;
        }

        back = (back+1)%maxSize;
        array[back] = value;
        size++;
    }

    public int dequeue(int value)
    {
        if (isEmpty())
        {
            return -1;
        }

        int temp = array[front];
        front = (front+1)%maxSize;
        size--;
        return temp;
    }
}
