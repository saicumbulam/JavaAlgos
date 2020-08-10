package Leetcode.LinkedList.Medium;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

public class ReorderList {
    public static void main(String[] args) {
        SingleLinkedList lst = new SingleLinkedList();
        ListNode curr = lst.CreateListSample();
        lst.printList(curr);
        ListNode result = Calculate(curr);
        lst.printList(curr);
    }

    private static ListNode Calculate(ListNode head)
    {
        if (head == null)
        {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode root = head, subroot = reverse(slow);

        while (root != null && subroot != null) // .next pointer is nessacary to avoid null pointer exception
        {
            ListNode temp = root.next;
            root.next = subroot;
            root = temp;

            temp = subroot.next;
            subroot.next = root;
            subroot = temp;
        }

        return root;
    }

    private static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode next = null, prev = null;
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
