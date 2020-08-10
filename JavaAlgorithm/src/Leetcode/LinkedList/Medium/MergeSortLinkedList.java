package Leetcode.LinkedList.Medium;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

public class MergeSortLinkedList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode root = list.CreateListSample();
        list.printList(Calculate(root));
    }

    private static ListNode Calculate(ListNode root)
    {
        return MergeSort(root);
    }

    private static ListNode MergeSort(ListNode root)
    {
        if(root == null || root.next == null)
        {
            return root;
        }

        Paired firstSecond = new Paired(null, null);
        SplitHalf(root, firstSecond);

        firstSecond.first = MergeSort(firstSecond.first);
        firstSecond.second = MergeSort(firstSecond.second);

        return Merger(firstSecond.first, firstSecond.second);
    }

    private static ListNode Merger(ListNode first, ListNode second)
    {
        // forgot this. This is important to deal null
        if (first == null)
        {
            return second;
        }

        // forgot this. This is important to deal null
        if (second == null)
        {
            return first;
        }

        ListNode resultHead = null, resultTail = null;

        if (first.value < second.value)
        {
            resultHead = first;
            first = first.next;
        }
        else {
            resultHead = second;
            second = second.next;
        }

        resultTail = resultHead;

        while (first != null && second != null)
        {
            if(first.value < second.value)
            {
                resultTail.next = first;
                first = first.next;
            }
            else
            {
                resultTail.next = second;
                second = second.next;
            }

            resultTail = resultTail.next;
        }

        // forgot abt this. ListNode doesnt needs while loop. Just use if statement
        if (first != null)
        {
            resultTail.next = first;
        }

        if (second != null)
        {
            resultTail.next = second;
        }

        return resultHead;
    }

    private static void SplitHalf(ListNode root, Paired firstSecond)
    {
        if(root == null)
        {
            return;
        }

        if(root.next == null)
        {
            firstSecond.first = root;
            firstSecond.second = null;
            return;
        }

        ListNode slow = root, fast = root.next; // this is very important to prevent infinte loop

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        firstSecond.first = root;
        firstSecond.second = slow.next; // this is very important to prevent infinte loop

        slow.next = null;
    }

    static class Paired
    {
        ListNode first;
        ListNode second;

        public Paired(ListNode first, ListNode second) {
            this.first = first;
            this.second = second;
        }

        public String toString()
        {
            return first + ", " + second;
        }
    }
}
