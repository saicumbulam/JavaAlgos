package Leetcode.Easy;

import Leetcode.DataStructures.LinkedList.ListNode;
import Leetcode.DataStructures.LinkedList.SingleLinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode node = list.CreateListSample();
        list.printList(node);
        ListNode result = Reverse(node);
        list.printList(result);
    }

    public static ListNode Reverse(ListNode node)
    {
        ListNode prev = null, next = null;
        ListNode curr = node;

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
