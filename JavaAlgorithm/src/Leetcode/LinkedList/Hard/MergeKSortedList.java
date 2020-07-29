package Leetcode.LinkedList.Hard;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        List<ListNode> listNodes = new ArrayList<>();
        listNodes.add(list.CreateListSample());
        listNodes.add(list.CreateListSample());
        ListNode result = Calculate(listNodes);
        list.printList(result);
    }

    private static ListNode Calculate(List<ListNode> lists)
    {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        for (ListNode item: lists
             ) {
            minHeap.add(item);
        }

        ListNode resultHead = null;
        ListNode resultTail = null;

        while (!minHeap.isEmpty())
        {
            ListNode polled = minHeap.poll();

            if(resultHead == null)
            {
                resultHead = polled;
            }
            else
            {
                resultTail.next = polled;
            }
            resultTail = polled;

            if(polled.next != null)
            {
                minHeap.add(polled.next);
            }
        }

        return resultHead;
    }
}
