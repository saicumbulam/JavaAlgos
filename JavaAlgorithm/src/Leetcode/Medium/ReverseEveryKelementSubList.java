package Leetcode.Medium;

import Leetcode.DataStructures.LinkedList.ListNode;
import Leetcode.DataStructures.LinkedList.SingleLinkedList;

public class ReverseEveryKelementSubList {

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

        while (true)
        {
            ListNode lastNodefirstPart = prev;
            ListNode lastNodeSubList = currentNode;
            ListNode next = null;

            for (int i = 0; i < k && currentNode != null; i++) {
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

            // This for continuation from the already reversed list
            prev = lastNodeSubList;
        }

        return root;
    }
}
