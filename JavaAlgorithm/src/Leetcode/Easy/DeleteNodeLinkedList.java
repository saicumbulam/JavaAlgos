package Leetcode.Easy;

import Leetcode.DataStructures.LinkedList.ListNode;
import Leetcode.DataStructures.LinkedList.SingleLinkedList;

public class DeleteNodeLinkedList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode node = list.CreateListSample();
        list.printList(node);
        DeleteNode(node);
        list.printList(node);
    }

    public static void DeleteNode(ListNode node)
    {
        node.value = node.next.value;
        node.next = node.next.next;
    }
}
