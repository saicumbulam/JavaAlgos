package Algorithms.Stack;


public class genericStack <Item>
{
    private Item container[];
    private int top;
    private final static int DEFAULT_SIZE = 100;

    public genericStack ()
    {
        this(DEFAULT_SIZE);
    }

    public genericStack (int initSize)
    {
        container = (Item[]) new Object [initSize];
        top = -1;
    }

    public Item getTop()
    {
        if (top == -1)
            return null;
        return container[top];
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }

    public Item pop()
    {
        if (top == -1)
            return null;
        return container[top--];
    }

    public void push(Item itm)
    {
        container[++top] = itm;
    }

    public int size()
    {
        return (top + 1);
    }

    public Item peek(){
        return container[top];
    }

}
