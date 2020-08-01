package Leetcode.ReverseLinkedList.Medium;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

public class ReverseAlternatingKSublist {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode node = list.CreateListSample();
        list.printList(node);
        ListNode result = Calculate(node, 2);
        list.printList(result);
    }

    private static ListNode Calculate(ListNode root, int k)
    {
        ListNode currentNode = root;
        ListNode prev = null;
        int length = ListLength(root);

        int count = 0;
        while (count + k <= length)
        {
            ListNode lastNodefirstPart = prev;
            ListNode lastNodeSubList = currentNode;
            ListNode next = null;

            for (int i = 0; i < k && currentNode != null; i++) {
                count++;
                next = currentNode.next;
                currentNode.next = prev;
                prev = currentNode;
                currentNode = next;
            }

            if (lastNodefirstPart != null)
            {
                lastNodefirstPart.next = prev;
            }
            else
            {
                root = prev;
            }
            lastNodeSubList.next = currentNode;

            if (currentNode == null)
            {
                break;
            }

            for (int i = 0; i < k; i++) {
                count++;
                prev = currentNode;
                currentNode = currentNode.next;
            }
        }

        return root;
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
