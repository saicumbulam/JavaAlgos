package Legacy.Algorithms.LinkedList;

public class CheckforCycle {
    public ListNode<Integer> hasCycle(ListNode<Integer> head){
        ListNode<Integer> fast = head, slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                // there is a cylec, lets calculate cycle length

                int cycleLen = 0;
                do {
                    ++cycleLen;
                    fast = fast.next;
                } while (slow != fast);

                //Find the start of the cycle

                ListNode<Integer> cycleAdvancedIter = head;

                while(cycleLen-- > 0){
                    cycleAdvancedIter = cycleAdvancedIter.next;
                }

                ListNode<Integer> iternode = head;
                while (iternode != cycleAdvancedIter){
                    iternode = iternode.next;
                    cycleAdvancedIter = cycleAdvancedIter.next;
                }
                return iternode; // iter is the start if cycle
            }
        }
        return null;
    }
}
