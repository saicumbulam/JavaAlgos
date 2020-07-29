package Leetcode.LinkedList.Medium;

public class FlattenMultilevelDoubleLinkedList {
    static class Node {
        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }

        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public String toString()
        {
            return String.format("val: %d, prev: %d, next: %d, child: %d", val ,
                    prev != null ? prev.val: 0,
                    next != null ? next.val: 0,
                    child != null ? child.val: 0);
        }
    }

    public static void main(String[] args) {
        Node prev = new Node(1,null, null, null);
        Node next = new Node(3,null, null, null);
        Node node = new Node(2,prev, next, null);
        prev.next = node;
        next.prev = node;
        Node result = flatten(prev);
    }

    public static Node flatten(Node head) {
        if (head == null)
        {
            return null;
        }

        Node dummy = new Node(0, null, head, null);

        dfs(dummy, head);

        dummy.next.prev = null;
        return dummy.next;
    }

    private static Node dfs(Node prev, Node curr)
    {
        if (curr == null)
        {
            return prev;
        }

        curr.prev = prev;
        prev.next = curr;

        Node next = curr.next;

        Node tail = dfs(curr, curr.child);
        curr.child = null;

        return dfs(tail, next);
    }
}
