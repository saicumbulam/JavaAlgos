package Leetcode.LinkedList.Medium;

import Leetcode.LinkedList.LinkedList.ListNode;

import java.util.Stack;

public class NextGreaterNodeLinkedList {
    public static void main(String[] args) {
        //1,7,5,1,9,2,5,1
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        int[] result = NextLargerNodes(head);

        for (int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }
    }

    private static int[] NextLargerNodes(ListNode head)
    {
        Stack<Integer> stack = new Stack<>();
        int length = GetLength(head);
        int[] result = new int[length];
        int index = result.length-1;


        ListNode current = Reverse(head);
        while (current != null)
        {
            while (!stack.isEmpty() && stack.peek() < current.value)
            {
                stack.pop();
            }

            result[index--] = stack.isEmpty() ? 0: stack.peek();
            stack.push(current.value);
            current = current.next;
        }

        return result;
    }

    private static ListNode Reverse(ListNode head)
    {
        ListNode current = head;
        ListNode prev = null;
        while (current != null)
        {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static int GetLength(ListNode head)
    {
        ListNode current = head;
        int count = 0;

        while (current != null)
        {
            count++;
            current = current.next;
        }
        return count;
    }
}
