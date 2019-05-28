package Algorithms.SingleLinkedList;

public class ListNode<T> {
    public T data;
    public ListNode<T> next;

    ListNode(T value) {
        data = value;
        next = null;
    }

    ListNode(T value, ListNode<T> nextval) {
        data = value;
        next = nextval;
    }
}
