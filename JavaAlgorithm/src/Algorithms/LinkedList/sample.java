package Algorithms.LinkedList;

import java.util.List;

public class sample {
    public ListNode<Integer> reverseSubList(ListNode<Integer> l, int start, int end) {
        ListNode<Integer> dummyHead = new ListNode<>(0, l);
        ListNode<Integer> subListHead = dummyHead;

        int k =1;

        while (k++ < start){
            subListHead = subListHead.next;
        }

        ListNode<Integer> iter = subListHead.next;
        while (start++ < end){
            ListNode<Integer> temp = iter.next;
            iter.next = temp.next;
            temp.next = subListHead.next;
            subListHead.next = temp;
        }
        return dummyHead.next;
    }
}
