package Algorithms.LinkedList;

public class RemoveDuplcicatesSortedList {
    public ListNode<Integer> removeDuplciates(ListNode<Integer> L) {
        ListNode<Integer> iter = L;

        while(iter != null){
            ListNode<Integer> nextDistinct = iter.next;
            while (nextDistinct != null && nextDistinct.data == iter.data){
                nextDistinct = nextDistinct.next;
            }
            iter.next = nextDistinct;
            iter = nextDistinct;
        }
        return L;
    }
}
