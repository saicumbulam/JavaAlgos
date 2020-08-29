package InterViewPrep.FastSlow;

import InterViewPrep.LinkedList;
import InterViewPrep.ListNode;

public class MiddleLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(new int[] {1,2,3,4,5,6});
        linkedList.printLn();
        System.out.println(Calculate(linkedList.head));
    }

    private static ListNode Calculate(ListNode root)
    {
        ListNode slow = root, fast = root;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
