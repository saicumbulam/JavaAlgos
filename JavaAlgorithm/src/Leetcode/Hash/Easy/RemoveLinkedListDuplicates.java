package Leetcode.Hash.Easy;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

import java.util.HashSet;

public class RemoveLinkedListDuplicates {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode node1 = list.CreateListSample();
        ListNode newNode = new ListNode(1);
        newNode.next = node1;
        list.printList(Calculate(newNode));
    }

    private static ListNode Calculate(ListNode root)
    {
        ListNode curr = root;
        ListNode prev = null;

        HashSet<Integer> set = new HashSet<>();

        while (curr != null)
        {
            if (!set.contains(curr.value))
            {
                set.add(curr.value);
                prev = curr;
            }
            else
            {
                prev.next = curr.next;
            }
            curr = curr.next;
        }

        return root;
    }
}
