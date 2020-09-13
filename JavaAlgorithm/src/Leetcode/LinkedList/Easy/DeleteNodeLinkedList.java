package Leetcode.LinkedList.Easy;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

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
