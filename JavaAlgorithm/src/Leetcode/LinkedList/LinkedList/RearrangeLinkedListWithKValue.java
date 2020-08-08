package Leetcode.LinkedList.LinkedList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class RearrangeLinkedListWithKValue {
    public static void main(String[] args) {
        ListNode newNode = new ListNode(3);
        newNode.next = new ListNode(0);
        newNode.next.next = new ListNode(5);
        newNode.next.next.next = new ListNode(2);
        newNode.next.next.next.next = new ListNode(1);
        newNode.next.next.next.next.next = new ListNode(4);
        int k = 3;
        ListNode result = Calculate(newNode, k);
        System.out.println(result);
    }

    private static ListNode Calculate(ListNode root , int k)
    {
        ListNode lesserhead = null;
        ListNode lesserTail = null;
        ListNode equal = null;
        ListNode greaterHead = null;
        ListNode greaterTail = null;

        ListNode curr = root;
        while (curr != null)
        {
            ListNode temp = curr.next;
            curr.next = null;

            if (curr.value < k)
            {
                if (lesserhead != null)
                {
                    lesserTail.next = curr;
                    lesserTail = lesserTail.next;
                }
                else
                {
                    lesserhead = curr;
                    lesserTail = lesserhead;
                }
            }
            else if (curr.value == k)
            {
                equal = curr;
            }
            else
            {
                if (greaterHead != null)
                {
                    greaterTail.next = curr;
                    greaterTail = greaterTail.next;
                }
                else
                {
                    greaterHead = curr;
                    greaterTail = greaterHead;
                }
            }

            curr = temp;
        }
        lesserTail.next = equal;
        equal.next = greaterHead;
        return lesserhead;
    }
}
