package Leetcode.Medium;

import Leetcode.DataStructures.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeLinkedList {
    public static void main(String[] args) {
        //1,7,5,1,9,2,5,1
        ListNode head = new ListNode(1);
        head.next = new ListNode(7);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(5);
        int[] result = NextLargerNodes(head);

        for (int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }
    }

    private static int[] NextLargerNodes(ListNode head)
    {
        Stack<Integer> stack = new Stack<>();
        List<Integer> arr = new ArrayList<>();
        while (head != null)
        {
            arr.add(head.value);
            head = head.next;
        }

        int[] result = new int[arr.size()];
        //Note the forward pass and filling the array.
        for (int i = 0; i < arr.size(); i++) {
            while (!stack.isEmpty() && arr.get(stack.peek()) < arr.get(i) )
            {
                result[stack.pop()] = arr.get(i);
            }
            stack.push(i);
        }

        return result;
    }
}
