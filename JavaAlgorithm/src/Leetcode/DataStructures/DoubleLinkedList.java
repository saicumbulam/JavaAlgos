package Leetcode.DataStructures;

public class DoubleLinkedList {
    public class Node
    {
        public int data;
        public Node prevNode;
        public Node nextNode;
    }

    Node headNode;
    Node tailNode;
    int size;

    public DoubleLinkedList()
    {
        headNode = null;
        tailNode = null;
    }

    public boolean isEmpty()
    {
        if (headNode == null && tailNode ==null )
        {
            return true;
        }
        return false;
    }

    public Node getHeadNode() {
        return headNode;
    }

    public Node getTailNode() {
        return tailNode;
    }

    public int getSize() {
        return size;
    }

    public void insertAtHead(int value)
    {
        Node newNode = new Node();
        newNode.data = value;
        newNode.nextNode = headNode;
        if(headNode != null)
        {
            headNode.prevNode = newNode;
        }
        else
        {
            tailNode = newNode;
        }
        headNode = newNode;
        size++;
    }

    public void insertAtEnd(int value)
    {
        if (isEmpty())
        {
            insertAtHead(value);
            return;
        }

        Node newNode = new Node();
        newNode.data = value;
        newNode.nextNode = null;
        tailNode.nextNode = newNode;
        newNode.prevNode = tailNode;
        tailNode = newNode;
        size++;
    }

    public void printList()
    {
        if (isEmpty())
        {
            System.out.println("Empty List");
            return;
        }

        Node temp = headNode;
        while (temp != null)
        {
            System.out.print("-->" + temp.data);
            temp = temp.nextNode;
        }

        System.out.print("--> Null");
    }

    public void printListReverse()
    {
        if (isEmpty())
        {
            System.out.println("Empty List");
            return;
        }

        Node temp = tailNode;
        while (temp != null)
        {
            System.out.print("-->" + temp.data);
            temp = temp.prevNode;
        }

        System.out.print("--> Null");
    }

    public void deleteAtHead()
    {
        if (isEmpty())
        {
            return;
        }

        headNode = headNode.nextNode;
        if (headNode == null)
        {
            tailNode = null;
        }
        else
        {
            headNode.prevNode = null;
        }
        size--;
    }

    public void deleteAtTail()
    {
        if (isEmpty())
        {
            return;
        }

        tailNode = tailNode.prevNode;
        if (tailNode == null)
        {
            headNode = null;
        }
        else
        {
            tailNode.nextNode = null;
        }
        size--;
    }


}
