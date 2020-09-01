/*
Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
Output: true
* */
package InterViewPrep.FastSlow;

import InterViewPrep.LinkedList;
import InterViewPrep.ListNode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(new int[] {2,4,6,4,2, 2});
        linkedList.printLn();
        System.out.println(Calculate(linkedList.head));
    }

    private static boolean Calculate(ListNode root)
    {
        ListNode resultHead = null;

        ListNode slow = root, fast = root;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode firstPart = root;
        ListNode secondPart = Reverse(slow);

        while (firstPart != null && secondPart != null)
        {
            if (firstPart.val != secondPart.val)
            {
                return false;
            }
            firstPart = firstPart.next;
            secondPart = secondPart.next;
        }

        if (firstPart == null || secondPart == null)
        {
            return true;
        }
        return false;
    }

    private static ListNode Reverse(ListNode head)
    {
        ListNode next = null;
        ListNode prev = null;
        ListNode curr = head;

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
