package Leetcode.LinkedList.Medium;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode root = list.CreateListSample();
        ListNode rootCh = Calculate(root);
        list.printList(rootCh);
    }

    private static ListNode Calculate(ListNode root)
    {
        ListNode odd = root, even = root.next, evenHead = even;
        while (even != null && even.next != null )
        {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return root;
    }
}
