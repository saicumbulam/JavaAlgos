/*
Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not
Time : O(N)
space: O(1)
* */
package InterViewPrep.FastSlow;

import InterViewPrep.LinkedList;
import InterViewPrep.ListNode;

public class StartOfLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(new int[] {1,2,3,4,5,6});
        linkedList.printLn();
        linkedList.createCycle();
        System.out.println(Calculate(linkedList.head));
    }

    private static ListNode Calculate(ListNode root) {

        ListNode slow = root.next, fast = root.next.next;
        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = root;

        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
