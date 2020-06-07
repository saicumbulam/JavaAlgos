package Leetcode.Medium;

import java.util.HashMap;

class Node
{
    int val;
    Node next;
    Node random;

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}

public class CopyListRandomPointer {
    static HashMap<Node, Node> hashMap;
    public static void main(String[] args) {
        hashMap = new HashMap<>();
        Node result = Calculate(new Node(5, null, null));
    }

    private static Node Calculate(Node head)
    {
        if(head == null)
        {
            return null;
        }

        if(hashMap.containsKey(head))
        {
            return hashMap.get(head);
        }

        Node newNode = new Node(head.val, null, null);
        hashMap.put(head, newNode);

        newNode.next = Calculate(head.next);
        newNode.random = Calculate(head.random);
        return newNode;

    }
}
