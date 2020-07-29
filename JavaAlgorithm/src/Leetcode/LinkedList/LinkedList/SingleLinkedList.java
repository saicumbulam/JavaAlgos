package Leetcode.LinkedList.LinkedList;

public class SingleLinkedList {
    public ListNode head;
    int size;

    public SingleLinkedList()
    {
        size = 0;
        head = null;
    }

    public void insertAtHead(int data)
    {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public void printList(ListNode node)
    {
        if (isEmpty())
        {
            System.out.println("List is empty");
            return;
        }

        ListNode temp = node;
        while (temp.next != null)
        {
            System.out.println(temp.value + ", ");
            temp = temp.next;
        }
        System.out.println(temp.value + "--> Null");
    }

    public void insertAtEnd(int data)
    {
        if (isEmpty())
        {
            insertAtHead(data);
            return;
        }

        ListNode newNode = new ListNode(data);
        ListNode temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
        size++;
    }

    public void insertAfter(int data, ListNode prev)
    {
        if (isEmpty())
        {
            insertAtHead(data);
            return;
        }

        ListNode newNode = new ListNode(data);
        ListNode temp = head;
        while (temp != null && temp.value != prev.value)
        {
            temp = temp.next;
        }
        if (temp != null)
        {
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }


    public boolean search (int data) {
        if (isEmpty()) {
            return false;
        }

        ListNode temp = head;
        while (temp != null) {
            if (temp.value == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void deleteAtHead(int value)
    {
        if (isEmpty())
        {
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteByValue(int value)
    {
        if (isEmpty())
        {
            return;
        }
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null && temp.value != value)
        {
            prev = temp;
            temp = temp.next;
        }

        if (prev != null)
        {
            prev.next = temp.next;
        }
        else
        {
            head = head.next;
        }
        size--;
    }

    public ListNode CreateListSample()
    {
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }

    public ListNode CreateCycle(ListNode current)
    {
        ListNode head = current;
        ListNode curr = current;
        while (curr.next != null)
        {
            curr = curr.next;
        }
        curr.next = head;
        return current;
    }
}
