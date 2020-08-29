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
            if (first.val != second.val)
            {
                return false;
            }
            first = first.next;
            second = second.next;
        }

        if (first == null && second == null)
        {
            return true;
        }
        return false;
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
