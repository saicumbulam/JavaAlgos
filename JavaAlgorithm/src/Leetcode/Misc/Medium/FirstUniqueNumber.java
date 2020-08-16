/*
Risky
* */
package Leetcode.Misc.Medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueNumber {

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        public FirstUniqueNumber(int[] nums) {
            for (int item: nums)
            {
                add(item);
            }
        }

        public int showFirstUnique() {
            if(queue.isEmpty())
            {
                return -1;
            }
            return queue.peek();
        }

        public void add(int value) {
            if(!set.contains(value))
            {
                queue.add(value);
                set.add(value);
            }
            else
            {
                Queue<Integer> buffer = new LinkedList<>();
                while(!queue.isEmpty())
                {
                    if(queue.peek() != value)
                    {
                        buffer.add(queue.poll());
                    }
                    else
                    {
                        queue.poll();
                    }
                }

                while(!buffer.isEmpty())
                {
                    queue.add(buffer.poll());
                }
            }
        }

}
