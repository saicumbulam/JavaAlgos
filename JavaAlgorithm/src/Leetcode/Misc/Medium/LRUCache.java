package Leetcode.Misc.Medium;

import java.util.HashMap;

public class LRUCache {
    static class Node
    {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class DoubleLinkedList
    {
        Node head;
        Node tail;

        public DoubleLinkedList()
        {
        }


        public boolean isEmpty()
        {
            return head == null && tail == null;
        }

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

        public void remove(Node node)
        {
            if (head == node)
            {
                head = head.next;
            }

            else if (tail == node)
            {
                tail = tail.prev;
            }

            else if (node.next != null)
            {
                node.next.prev = node.prev;
            }

            else if (node.prev != null)
            {
                node.prev.next = node.next;
            }

        }
    }

    static class LRU
    {
        HashMap<Integer, Node> cache = new HashMap<>();
        DoubleLinkedList dll = new DoubleLinkedList();
        int capacity;

        public LRU(int capacity){ this.capacity = capacity; }

        public int get(int key) {
            if (cache.containsKey(key))
            {
                Node newNode = cache.get(key);
                dll.remove(newNode);
                dll.push(newNode);
                return newNode.val;
            }
            return -1;
        }

        public void put(int key, int value) {

            if (cache.containsKey(key))
            {
                dll.remove(cache.get(key));
            }
            else if (cache.size() >= capacity)
            {
                Node tail = dll.tail;
                dll.remove(tail);
                cache.remove(tail.key);
            }

            Node temp = new Node(key, value);
            dll.push(temp);
            cache.put(key, temp);
        }
    }

    public static void main(String[] args) {
        LRU cache = new LRU( 2 );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
