package Leetcode.LinkedList.FastSlow.Easy;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

public class MiddleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode temp = list.CreateListSample();
        list.printList(temp);
        System.out.println(Calculate(temp));
    }

    private static ListNode Calculate(ListNode root)
    {
        ListNode slow = root, fast = root;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.value);
        return slow;
    }
}
