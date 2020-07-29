package Leetcode.LinkedList.Easy;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        SingleLinkedList lst = new SingleLinkedList();
        ListNode head = lst.CreateListSample();
        int val = 3;
        ListNode result = Calculate(head, val);
        lst.printList(result);
    }

    private static ListNode Calculate(ListNode head, int val)
    {
        // should be present to avoid certain test cases
        // problem like [1] and [1,1] with value removal 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        ListNode curr = head;

        while (curr != null)
        {
            if (curr.value == val)
            {
                prev.next = curr.next;
            }
            else // this is very important for some test cases
            {
                prev = curr;
            }
            curr = curr.next;
        }

        // should be present to avoid certain test cases
        // problem like [1] and [1,1] with value removal 1
        return dummy.next;
    }
}
