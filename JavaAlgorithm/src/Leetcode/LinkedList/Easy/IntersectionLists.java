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
        int LengthA = LengthList(list1);
        int LengthB = LengthList(list2);

        if(LengthA < LengthB)
        {
            return Check(list2, list1);
        }

        while (LengthA > LengthB)
        {
            list1 = list1.next;
            LengthA--;
        }

        while (list1 != null && list2 != null)
        {
            if(list1 == list2)
            {
                return true;
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        return false;

    }

    private static int LengthList(ListNode head)
    {
        ListNode curr = head;
        int count = 0;
        while (curr != null)
        {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
