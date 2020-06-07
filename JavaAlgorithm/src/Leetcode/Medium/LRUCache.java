package Leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static class Node
    {
        int val;
        int key;
        Node next;
        Node prev;

        public Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    static class DoublyLinkedList
    {
        Node head;
        Node tail;

        public void push(Node n)
        {
            n.next = head;
            n.prev = null;
            if (head == null)
            {
                tail = n;
            }
            else
            {
                head.prev = n;
            }

            head = n;
        }

        public void remove(Node n)
        {
            if (n == head)
            {
                head = head.next;
            }

            if (n == tail)
            {
                tail = tail.prev;
            }

            if (n.next != null)
            {
                n.next.prev = n.prev;
            }

            if (n.prev != null)
            {
                n.prev.next = n.next;
            }
        }
    }

    static Map<Integer, Node> hashMap = new HashMap<>();
    static int capacity;
    static  DoublyLinkedList dll = new DoublyLinkedList();

    public LRUCache(int key)
    {
        capacity = key;
    }

    public static int get(int key)
    {
        if (hashMap.containsKey(key))
        {
            Node n = hashMap.get(key);
            dll.remove(n);
            dll.push(n);
        }

        return -1;
    }

    public static void put(int key, int value)
    {
        if (hashMap.containsKey(key))
        {
            dll.remove(hashMap.get(key));
        }
        else if (hashMap.size() >= capacity)
        {
            Node lru = dll.tail;
            dll.remove(lru);
            hashMap.remove(lru);
        }

        Node newNode = new Node(key, value);
        dll.push(newNode);
        hashMap.put(key, newNode);
    }


    public static void main(String[] args) {

    }
}
