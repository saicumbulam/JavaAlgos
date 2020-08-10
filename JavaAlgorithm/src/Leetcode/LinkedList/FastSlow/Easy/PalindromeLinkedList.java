package Leetcode.LinkedList.FastSlow.Easy;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(2);
        list.insertAtHead(1);
        System.out.println(Check(list.head));
    }

    private static boolean Check(ListNode head)
    {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firtsHalf = head;
        ListNode reversehalf = Reverse(slow);

        while (firtsHalf != null && reversehalf != null)
        {
            if (reversehalf.value != firtsHalf.value) {
                return false ;
            }
            firtsHalf = firtsHalf.next;
            reversehalf = reversehalf.next;
        }

        if(firtsHalf == null || reversehalf == null) {
            return true;
        }
        return false;
    }

    private static ListNode Reverse(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null, next = null;
        while (curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
