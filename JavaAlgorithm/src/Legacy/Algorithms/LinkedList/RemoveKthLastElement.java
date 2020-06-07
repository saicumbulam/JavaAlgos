package Legacy.Algorithms.LinkedList;

public class RemoveKthLastElement {
    public ListNode<Integer> removeKthLast(ListNode<Integer> L , int k) {
        ListNode<Integer> dummyHead = new ListNode<>(0, L);
        ListNode<Integer> first = dummyHead.next;

        while(k-- > 0) {
            first = first.next;
        }

        ListNode<Integer> second = dummyHead;
        while(first != second){
            first = first.next;
            second = second.next;
        }

        // second points to the k-1 last node, deletes its successor
        second.next = second.next.next;
        return dummyHead.next;
    }
}
