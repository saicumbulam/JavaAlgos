package Leetcode.FastSlow.Medium;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

public class RearrangeLinkedList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode temp = list.CreateListSample();
        list.printList(temp);
        temp = Calculate(temp);
        list.printList(temp);
    }

    private static ListNode Calculate(ListNode root) {
        ListNode slow = root, fast = root;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode firstHalf = root;
        ListNode secondHalf = Reverse(slow);

        // if result is not proper, watch for the below critical part
        while (firstHalf!= null && secondHalf != null)
        {
            ListNode temp = firstHalf.next;
            firstHalf.next = secondHalf;
            firstHalf = temp;

            temp = secondHalf.next;
            secondHalf.next = firstHalf;
            secondHalf = temp;
        }

        if (firstHalf != null)
        {
            firstHalf.next = null;
        }
        return root;
    }

    private static ListNode Reverse(ListNode root)
    {
        ListNode curr = root;
        ListNode prev = null;

        while (curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }
}
