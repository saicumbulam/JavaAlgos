package Leetcode.LinkedList.Easy;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

public class IntersectionLists {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(2);
        list.insertAtHead(1);
        System.out.println(Check(list.head, list.head));
    }

    private static boolean Check(ListNode list1, ListNode list2)
    {
        if (list1 == null && list2 == null)
        {
            return false;
        }

        if (list1 == null || list2 == null)
        {
            return false;
        }

        int length1 = getLength(list1);
        int length2 = getLength(list2);

        if (length2 > length1)
        {
            return Check(list2, list1);
        }

        int skip = length1 - length2;

        while (skip > 0)
        {
            list1 = list1.next;
            skip--;
        }

        while (list1 != null && list2 != null)
        {
            if (list1 == list2)
            {
                return true;
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        return false;
    }

    private static int getLength(ListNode head)
    {
        int curr = 0;

        while (head != null)
        {
            curr++;
            head = head.next;
        }
        return curr;
    }
}
