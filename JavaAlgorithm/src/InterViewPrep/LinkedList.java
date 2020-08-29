package InterViewPrep;

public class LinkedList {
    public ListNode head;

    public LinkedList(int val)
    {
        head = new ListNode(val);
    }

    public LinkedList(int[] arr)
    {
        for (int item: arr
             ) {
            add(item);
        }
    }

    public void add(int val)
    {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    public void del(int val)
    {
        if (isEmpty())
        {
            return;
        }

        if (head.val == val)
        {
            head = head.next;
            return;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null && curr.val != val)
        {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) // avoid null reference exception
        {
            return;
        }

        if (prev != null)
        {
            prev.next = curr.next;
        }
    }

    private boolean isEmpty() {
        if (head == null)
        {
            return true;
        }
        return false;
    }

    public void createCycle()
    {
        ListNode curr = head;
        while (curr.next != null)
        {
            curr = curr.next;
        }
        curr.next = head;
    }

    public void printLn()
    {
        ListNode curr = head;
        while (curr != null)
        {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}
