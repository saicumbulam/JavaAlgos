/*
Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null
* */
package InterViewPrep.FastSlow;

import InterViewPrep.LinkedList;
import InterViewPrep.ListNode;

public class RearrangeLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(new int[] {2,4,6,4,2, 2});
        linkedList.printLn();
        System.out.println("-----------");
        ListNode result = Calculate(linkedList.head);
        linkedList.head = result;
        linkedList.printLn();
    }

    private static ListNode Calculate(ListNode root)
    {
        ListNode slow = root, fast = root;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = root;
        ListNode second = Reverse(slow);

        while (first != null && second != null)
        {
            ListNode temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;

        }
        if (first != null)  // infinite loop
        {
            first.next = null;
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
