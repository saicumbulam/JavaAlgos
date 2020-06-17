package Leetcode.Medium;

import Leetcode.DataStructures.LinkedList.ListNode;
import Leetcode.DataStructures.LinkedList.SingleLinkedList;
import org.jcp.xml.dsig.internal.dom.ApacheTransform;

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

        while (subroot.next != null) // .next pointer is nessacary to avoid null pointer exception
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
