package Algorithms.Stack;

public class Stack {
    private int Max = 1000;
    private int[] array = new int[Max];
    private int top;

    public boolean isEmpty(){
        return (top < 0);
    }

    // constructor
    Stack(){
        top = -1;
    }

    public boolean push(int value)
    {
        if (top >= (Max -1)) {
            System.out.println("Algorithms.Stack overflow");
            return false;
        } else {
            array[++top] = value;
            System.out.println("Value pushed into the stack");
            return true;
        }
    }

    public int Pop(){
        if (top < 0){
            System.out.println("Algorithms.Stack underflow");
            return -1;
        } else {
            return array[top--];
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            str.append(array[i]);
        }
        return str.toString();
    }

    public int getSize() {
        return top;
    }

    public int Peek(){
        return array[top];
    }
}
