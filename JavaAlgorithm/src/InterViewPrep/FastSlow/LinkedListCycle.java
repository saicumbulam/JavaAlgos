package InterViewPrep.FastSlow;

import InterViewPrep.LinkedList;
import InterViewPrep.ListNode;

public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(new int[] {1,2,3,4,5,6});
        linkedList.createCycle();
        System.out.println(Calculate(linkedList.head));
    }

    private static boolean Calculate(ListNode root)
    {
        ListNode slow = root, fast = root;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
            {
                return true;
            }
        }
        return false;
    }
}
