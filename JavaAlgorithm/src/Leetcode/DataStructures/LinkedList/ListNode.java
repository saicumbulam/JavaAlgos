package Leetcode.DataStructures.LinkedList;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int val)
    {
        value = val;
        next = null;
    }

    public String toString()
    {
        return String.valueOf(value);
    }
}
