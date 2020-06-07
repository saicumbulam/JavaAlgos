package Legacy.Algorithms.LinkedList;

public class ReverseSubList {
    public ListNode<Integer> reverseSubList(ListNode<Integer> L, int start, int finish){
        ListNode<Integer> dummyHead = new ListNode<>(0, L);
        ListNode<Integer> sublistHead = dummyHead;

        int k = 1;

        while(k++ < start){
            sublistHead = sublistHead.next;
        }

        ListNode<Integer> subListIter = sublistHead.next;
        while (start++ < finish){
            ListNode<Integer> temp = subListIter.next;
            subListIter.next = temp.next;
            temp.next = sublistHead.next;
            sublistHead.next = temp;
        }
        return dummyHead.next;
    }
}
