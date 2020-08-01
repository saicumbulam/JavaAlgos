/*
1. Get length of the list till curr.next
2. calculate skiplength = list - rotations. iterate list till < skip length.
3. connect head = list.next and list.next = null
* */
package Leetcode.ReverseLinkedList.Easy;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

public class RotateLinkedList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode node = list.CreateListSample();
        list.printList(node);
        ListNode result = Calculate(node, 1);
        list.printList(result);
    }

    private static ListNode Calculate(ListNode root, int k) {
        if (root == null || root.next == null || k <= 0) {
            return root;
        }

        int length = 0;
        ListNode currentNode = root;

        // dont forget the curr.next , as it will produce a null pointer exception
        while (currentNode.next != null) {
            length++;
            currentNode = currentNode.next;
        }

        currentNode.next = root;

        k %= length;
        int skip = length - k;

        ListNode lastNode = root;
        for (int i = 0; i < skip; i++) {
            lastNode = lastNode.next;
        }

        root = lastNode.next;
        lastNode.next = null;

        return root;
    }
}
