/*
1. do fast and slow pointer and get the position where 2 pointers meet.
2. calculate the cycle length from the slow.
   cycle length is curr pointer when it meets the slow
3. Get the start of the cycle, from pointer ptr1 and ptr2.
   the point it meets is the start of the cycle.

* */
package Leetcode.FastSlow.Easy;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

public class LinkedListStartCycle {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode temp = list.CreateListSample();
        list.printList(temp);
        ListNode cycle = list.CreateCycle(temp);
        System.out.println(Calculate(cycle));
    }

    private static ListNode Calculate(ListNode root)
    {
        ListNode fast = root, slow = root;
        int cyclelength = 0;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
            {
                cyclelength = findCycleLength(slow);
                break; // break avoids infinite loop
            }
        }
        return findStart(root, cyclelength);
    }

    private static ListNode findStart(ListNode root, int cyclelength) {
        ListNode ptr1 = root, ptr2 = root;

        while (cyclelength > 0)
        {
            ptr1 = ptr1.next;
            cyclelength--;
        }

        while (ptr1 != ptr2)
        {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    private static int findCycleLength(ListNode slow) {
        ListNode curr = slow;
        int count = 0;

        do {
            curr = curr.next;
            count++;
        } while (curr != slow);

        return count;
    }


}
