package Algorithms.SingleLinkedList;

public class BasicOperation<T> {

    //Search the BasicOperation
    public ListNode<T> search(ListNode<T> L, T key) {
        while (L != null && L.data != key) {
            L = L.next;
        }

        // If key was not present in the list, L will have become null.
        return L;
    }

    //Insert newNode after node.
    public void insertAfter(ListNode<T> node, ListNode<T> newNode) {
        newNode.next = node.next;
        node.next = newNode;
    }

    //Delete the node immediately following aNode. Assumes aNode is not a tail.

    public void deleteList(ListNode <T> aNode) {
        aNode.next = aNode.next.next ;
    }

    public void traversalList(ListNode<T> node) {

        while (node != null)
        {
            System.out.println("Data is --> " + node.data);
            node = node.next;
        }
    }

    public ListNode<T> advanceList(int k,ListNode<T> L)
    {
        while (k-- > 0){
            L = L.next;
        }
        return L;
    }

    public int length(ListNode<T> L) {
        int length = 0;
        while (L != null){
            length++;
            L = L.next;

        }
        return length;
    }

}
