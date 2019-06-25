package Algorithms.LinkedList;

public class SearchKey {
    public ListNode<Integer> searchList(ListNode<Integer> L, int key){
        while (L != null && L.data != key){
            L = L.next;
        }
        return L;
    }
}
