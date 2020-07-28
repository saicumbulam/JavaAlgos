/* Time complexity = o(n) and space complexity: o(1)*/
package Leetcode.Medium;

import Leetcode.DataStructures.LinkedList.ListNode;
import Leetcode.DataStructures.LinkedList.SingleLinkedList;

public class ReverseSubList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode node = list.CreateListSample();
        list.printList(node);
        ListNode result = Calculate(node, 2,4);
        list.printList(result);
    }

    private static ListNode Calculate(ListNode root, int p, int q)
    {
        ListNode currentNode = root;
        ListNode prev = null;

        // watch for p-1
        for (int i = 0; i < p-1; i++) {
            prev = currentNode;
            currentNode = currentNode.next;
        }

        ListNode lastNodefirstPart = prev;
        ListNode lastNodeSubList = currentNode;
        ListNode next = null;

        // watch for q-p+1
        for (int i = 0; i < q-p+1 && currentNode != null; i++) {
            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }

        // .next will not come. Avoid Null pointer exception
        if (lastNodefirstPart != null)
        {
            lastNodefirstPart.next = prev;
        }
        else
        {
            // assign the root to prev
            root = prev;
        }
        lastNodeSubList.next = currentNode;

        return root;
    }
}
