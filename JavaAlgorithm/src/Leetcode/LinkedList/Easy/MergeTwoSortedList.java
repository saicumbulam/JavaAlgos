package Leetcode.LinkedList.Easy;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        ListNode list1 = linkedList.CreateListSample();
        ListNode list2 = linkedList.CreateListSample();
        ListNode result = Merge(list1, list2);
        linkedList.printList(result);
    }

    private static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
        {
            return list2;
        }
        if (list2 == null)
        {
            return list1;
        }

        ListNode resultHead = null;

        if (list1.value < list2.value)
        {
            resultHead = list1;
            list1 = list1.next;
        }
        else
        {
            resultHead = list2;
            list2 = list2.next;
        }

        ListNode resultTail = resultHead;

        while (list1 != null && list2 != null)
        {
            if (list1.value < list2.value)
            {
                resultTail.next = list1;
                list1 = list1.next;
            }
            else
            {
                resultTail.next = list2;
                list2 = list2.next;
            }
            resultTail = resultTail.next;
        }

        if (list1 != null) resultTail.next = list1;
        if (list2 != null) resultTail.next = list2;
        return resultHead;
    }


}
