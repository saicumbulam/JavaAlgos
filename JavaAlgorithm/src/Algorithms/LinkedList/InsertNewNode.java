package Algorithms.LinkedList;

public class InsertNewNode {
    public void insertAfter(ListNode<Integer> oldNode, ListNode<Integer> newNode){
        newNode.next = oldNode.next;
        oldNode.next = newNode;
    }
}
