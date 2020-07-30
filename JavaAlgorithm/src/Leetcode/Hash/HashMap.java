package Leetcode.Hash;

import java.util.ArrayList;

public class HashMap {
    class HashEntry
    {
        String key;
        int value;

        HashEntry next;

        public HashEntry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    ArrayList<HashEntry> bucket = new ArrayList<>();
    int size = 0;
    int slots = 0;

    public HashMap(int slots) {
        this.slots = slots;
        size = 0;

        for (int i = 0; i < slots; i++) {
            bucket.add(null);
        }
    }

    public int getIndex(String key)
    {
        int hash = key.hashCode();
        int index = hash%slots;
        return index;
    }

    public int get (String key)
    {
        int b_index = getIndex(key);
        HashEntry head = bucket.get(b_index);

        while (head != null)
        {
            if (head.key.equals(key))
            {
                return head.value;
            }
            head = head.next;
        }

        return -1;
    }

    public void insert(String key, int value)
    {
        int b_index = getIndex(key);
        HashEntry head = bucket.get(b_index);

        while (head != null)
        {
            if (head.key.equals(key))
            {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = bucket.get(b_index);
        HashEntry newNode = new HashEntry(key, value);
        newNode.next = head;
        bucket.set(b_index, newNode);

        if (((1.0) * size)/slots >= 0.6)  // 1.0  is for float division error
        {
            ArrayList<HashEntry> temp = bucket;
            bucket = new ArrayList<>();
            slots = 2 * slots;
            size = 0;

            for (HashEntry item: temp
                 ) {
                while (item != null)
                {
                    insert(item.key, item.value);
                    item = item.next;
                }
            }
        }
    }

    public int delete(String key)
    {
        int b_index = getIndex(key);
        HashEntry head = bucket.get(b_index);
        HashEntry prev = null;

        while (head != null)
        {
            if (head.key.equals(key))
            {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null)
        {
            return -1;
        }

        size--;
        if (prev != null)
        {
            prev.next = head.next;
        }
        else
        {
            // setting a new head. so to delete the previous head
            bucket.set(b_index, head.next);
        }

        return head.value;
    }
}
