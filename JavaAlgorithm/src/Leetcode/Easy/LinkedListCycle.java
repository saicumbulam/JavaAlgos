package Leetcode.Easy;

import Leetcode.DataStructures.LinkedList.ListNode;
import Leetcode.DataStructures.LinkedList.SingleLinkedList;

public class LinkedListCycle {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode temp = list.CreateListSample();
        list.printList(temp);
        ListNode cycle = list.CreateCycle(temp);
        System.out.println(Calculate(cycle));
    }

    public static boolean Calculate(ListNode node)
    {
        ListNode slow = node, fast = node;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                return true;
            }
        }
        return false;
    }
}
