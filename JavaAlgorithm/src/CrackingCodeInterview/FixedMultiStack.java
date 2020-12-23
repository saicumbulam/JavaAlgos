package CrackingCodeInterview;

public class FixedMultiStack {
    private int numOfStacks = 3;
    private int stackCapacity;
    private int[] arr;
    private int[] stackSizes;

    // all stacks have same size
    // arr becomes triple size of stack
    public FixedMultiStack(int stackCapacity) {
        this.stackCapacity = stackCapacity;
        arr = new int[numOfStacks * this.stackCapacity];
        stackSizes = new int[numOfStacks];
    }

    // increment size of a stack
    // put value on top
    public void push(int stackNum, int value) {
        stackSizes[stackNum]++;
        arr[indexOfTop(stackNum)] = value;
    }


    public int pop(int stackNum) {
        int value = arr[indexOfTop(stackNum)];
        stackSizes[stackNum]--;
        return value;
    }

    private boolean isFull(int stackNum) {
        return stackSizes[stackNum] == stackCapacity;
    }

    private boolean isEmpty(int stackNum)
    {
        return stackSizes[stackNum] == 0;
    }

    // core part of application. get the initial offset of the array
    // get the size of the stack. then use formulae
    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = stackSizes[stackNum];
        return offset + size - 1;
    }
}
