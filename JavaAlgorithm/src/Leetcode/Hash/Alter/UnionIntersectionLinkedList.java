package Leetcode.Hash.Alter;

import Leetcode.LinkedList.LinkedList.ListNode;
import Leetcode.LinkedList.LinkedList.SingleLinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UnionIntersectionLinkedList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        ListNode node1 = list.CreateListSample();
        ListNode node2 = list.CreateListSample();
        Union(node1, node2);
        Intersection(node1, node2);
    }

    private static void Union(ListNode node1, ListNode node2)
    {
        ListNode curr1 = node1 , curr2 = node2;
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        while (curr1 != null)
        {
            set.add(curr1.value);
            curr1 = curr1.next;
        }

        while (curr2 != null)
        {
            if (set.contains(curr2.value))
            {
                result.add(curr2.value);
            }
            curr2 = curr2.next;
        }

        System.out.println(result);
    }

    private static void Intersection(ListNode node1, ListNode node2)
    {
        ListNode curr1 = node1 , curr2 = node2;
        HashSet<Integer> set = new HashSet<>();

        while (curr1 != null)
        {
            set.add(curr1.value);
            curr1 = curr1.next;
        }

        while (curr2 != null)
        {
            if (!set.contains(curr2.value))
            {
                set.add(curr2.value);
            }
            curr2 = curr2.next;
        }

        System.out.println(set);
    }
}
