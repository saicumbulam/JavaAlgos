package Algorithms.LinkedList;

import java.util.List;

public class Merge2SortedList {
    public ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
                                                 ListNode<Integer> L2){
        ListNode<Integer> dummyHead = new ListNode<>(0, null);
        ListNode<Integer> current = dummyHead;

        while(L1 != null && L2 != null){
            if (L1.data < L2.data) {
                current.next = L1;
                L1 = L1.next;
            } else {
                current.next = L2;
                L2 = L2.next;
            }
            current = current.next;
        }
        current.next = L1 != null ? L1 : L2;
        return dummyHead.next;
    }

}
