package Algorithms.SingleLinkedList;

public class CreateLinkedList {
    private ListNode<Integer> head;
    private static BasicOperation<Integer> ops = new BasicOperation<Integer>();
    private static AdvancedOperation advops = new AdvancedOperation();

    public static void main(String[] args) {
        CreateLinkedList llist = new CreateLinkedList();
        llist.head = new ListNode<Integer>(1);

        ListNode<Integer> dummy = llist.head;

        // for loop create a linked list
        for (int i = 2; i < 10; i++) {
            ListNode<Integer> temp = new ListNode<Integer>(3);
            dummy.next = temp;
            dummy = dummy.next;
        }

        // traverse a list
        ops.traversalList(llist.head);

        advops.RemoveDuplicates(llist.head);

    }
}
