package Leetcode.LinkedList.Medium;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode head1 = list.CreateListSample();
        list.printList(head1);
        ListNode head2 = list.CreateListSample();
        ListNode result = Calculate(head1, head2);
        list.printList(result);
    }

    private static ListNode Calculate(ListNode l1, ListNode l2)
    {
        int sum = 0, result = 0, carry = 0;

        ListNode resultHead = null;
        ListNode resultTail = null;

        while (l1 != null || l2 != null || carry > 0)
        {
            int i1 = l1 == null ? 0 : l1.value;
            int i2 = l2 == null ? 0 : l2.value;
            sum = i1 + i2 + carry;
            carry = sum/10;
            ListNode newNode = new ListNode(sum % 10);
            if(resultHead == null)
            {
                resultHead = newNode;
            }
            else
            {
                resultTail.next = newNode;
            }
            resultTail = newNode;
            if(l1 != null)
            {
                l1 = l1.next;
            }
            if(l2 != null)
            {
                l2 = l2.next;
            }
        }
        return resultHead;
    }
}
