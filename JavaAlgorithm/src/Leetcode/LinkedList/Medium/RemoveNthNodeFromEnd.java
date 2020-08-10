package Leetcode.LinkedList.Medium;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode node = list.CreateListSample();
        list.printList(Calculate(node, 2));
    }

    private static ListNode Calculate(ListNode head, int n)
    {
        int size = GetLength(head);
        // this is from the end
        n = size-n;

        ListNode curr = head, prev = null;

        while (n > 0)
        {
            prev = curr;
            curr = curr.next;
            n--;
        }

        if (prev != null)
        {
            prev.next  = curr.next;
        }
        else {
            head = head.next;
        }

        return head;
    }

    private static int GetLength(ListNode root)
    {
        int count = 0;
        ListNode curr = root;
        while (curr != null)
        {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
