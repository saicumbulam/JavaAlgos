package Leetcode.Hard;

import Leetcode.DataStructures.LinkedList.ListNode;
import Leetcode.DataStructures.LinkedList.SingleLinkedList;

public class ReverseLinkedListKNodes {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode node = list.CreateListSample();
        ListNode result =Calculate(node, 3);
        list.printList(result);
    }

    private static ListNode Calculate(ListNode node, int k)
    {
        ListNode current = node, previous = null;
        int length = ListLength(node);

        int count = 0;
        //watchout
        while (count + k <= length) // used to prevent reverse of last nodes that are less than K.
        {
            ListNode lastNodePrevious = previous;
            ListNode lastNodeSublist = current;
            ListNode next = null;

            for (int i = 0; current != null && i < k; i++) {
                count++;
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            //watchout
            if (lastNodePrevious != null)
            {
                lastNodePrevious.next = previous;
            }
            else
            {
                node = previous;
            }
            //watchout
            lastNodeSublist.next = current;  // forgetting will give a infinte loop

            if (current == null)
            {
                break;
            }
            //watchout
            previous = lastNodeSublist;
        }

        return node;
    }

    private static int ListLength(ListNode node) {
        ListNode curr = node;
        int count = 0;
        while (curr != null)
        {   count++;
            curr = curr.next;
        }
        return count;
    }
}
