package Algorithms.SingleLinkedList;

public class AdvancedOperation {
    private BasicOperation ops = new BasicOperation();

    // Merge two sorted list
    public ListNode<Integer> MergeTwoSortedList(ListNode<Integer> l1, ListNode<Integer> l2)
    {
        ListNode<Integer> dummyHead = new ListNode<Integer>(0);
        ListNode<Integer> current = dummyHead;

        ListNode<Integer> p1 = l1, p2 = l2;

        while(p1 != null && p2 != null)
        {
            //assign the next as the p1 or p2
            if (p1.data < p2.data) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }

            //move to next node
            current = current.next;
        }
        current.next = (p1 != null) ? p1 : p2;

        //return from the header
        return dummyHead.next;
    }

    // Reverse a sub list
    public ListNode<Integer> reverseSublist(ListNode<Integer> L, int start, int finish)
    {
        //base case
        if (start == finish) {
            return L;
        }

        ListNode<Integer> dummyHead = new ListNode<Integer>(0,L);
        ListNode<Integer> subListHead = dummyHead;
        int k = 1;

        // position the node upto the start point
        while (k++ < start) {
            subListHead = subListHead.next;
        }

        // make a list from the start point
        ListNode<Integer> sublistIter = subListHead.next;

        // Reverse the sublist
        // procedure for reversing
        // 1. temp = next_substr  ---> create temp node
        // 2. next_substr = temp_next ---> create temp next
        // 3. temp_next = sublisthead_next ---> assign sublisthead to a temp
        // 4. sublistHEad_next = temp ---> assign sublisthead to a temp

        while (start++ < finish) {
            ListNode<Integer> temp = sublistIter.next;
            sublistIter.next = temp.next;
            temp.next = subListHead.next;
            subListHead.next = temp;
        }

        // return the whole list
        return dummyHead.next;
    }

    public ListNode<Integer> hasCycle(ListNode<Integer> head) {
        ListNode<Integer> fast = head, slow = head;

        while (fast != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                //There is a cycle. so now lets calculate the length of cycle.

                // iterate the list by using fast and see if its same.
                int cycleLen = 0;
                do {
                    ++cycleLen;
                    fast = fast.next;

                }while (fast != slow);

                // Find the start of the cycle
                ListNode<Integer> cycleLenAdvInteger = head;
                while (cycleLen-- > 0){
                    cycleLenAdvInteger = cycleLenAdvInteger.next;
                }


                ListNode<Integer> iter = head;

                // Both iterators advance
                while (iter != cycleLenAdvInteger){
                    iter = iter.next;
                    cycleLenAdvInteger = cycleLenAdvInteger.next;
                }
                return iter;
            }
        }
        return null;
    }

    public ListNode<Integer> overlappingLists(ListNode<Integer> l1, ListNode<Integer> l2){
        int l1length = ops.length(l1), l2length = ops.length(l2);

        //Advance the longer list to meet the shorter length
        if (l1length > l2length) {
            l1 = ops.advanceList(l1length-l2length, l1);
        } else {
            l2 = ops.advanceList((l2length-l1length), l2);
        }

        while (l1 != null && l2 != null && l1 != l2){
            l1 = l1.next;
            l2 = l2.next;
        }
        // null implies there is no overlap between l1 and l2

        return l1;
    }

    public ListNode<Integer> DeletionfromLists(ListNode<Integer> node){
        node.data = node.next.data;
        node.next = node.next.next;
        return node;
    }

    public ListNode<Integer> RemoveKthList(ListNode<Integer> l, int k){
        ListNode<Integer> dummyHead = new ListNode<>(0,l);
        ListNode<Integer> first = dummyHead.next;
        // first iterator advance k steps
        while (k-- > 0){
            first = first.next;
        }

        // let first iterator reaches tail and then make second reach the kth
        ListNode<Integer> second = dummyHead;
        while (first != null){
            second = second.next;
            first = first.next;
        }

        // delete the k+1 th node by pointing to the next
        second.next = second.next.next;
        return dummyHead.next;
    }

    public ListNode<Integer> RemoveDuplicates(ListNode<Integer> l){
        ListNode<Integer> iter = l;
        while (iter != null){
            ListNode<Integer> nextDistinct = iter.next;
            while (nextDistinct != null && nextDistinct.data == iter.data){
                nextDistinct = nextDistinct.next;
            }
            iter.next = nextDistinct;
            iter = nextDistinct;
        }
        return l;
    }
}
