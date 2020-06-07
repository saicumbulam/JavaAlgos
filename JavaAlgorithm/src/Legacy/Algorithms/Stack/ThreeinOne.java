package Legacy.Algorithms.Stack;

import java.util.EmptyStackException;

public class ThreeinOne {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public ThreeinOne(int stackSize){
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks]; // each stack number is a slot
    }

    public void push(int stackNum, int value) throws StackOverflowError {
        if(isFull(stackNum)){
            throw new StackOverflowError();
        }
        sizes[stackNum]++; // each slot increase
        values[indexOfTop(stackNum)] = value;
    }

    private boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }

    private boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }

    public int pop(int stackNum){
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0; // clear
        sizes[stackNum]--; //shrink
        return value;
    }

    public int peek(int stackNum){
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }
    private int indexOfTop(int stackNum){
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}
