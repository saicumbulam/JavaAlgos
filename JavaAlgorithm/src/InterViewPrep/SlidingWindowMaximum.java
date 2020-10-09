package InterViewPrep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = Calculate(nums, k);
        for (int item: result
             ) {
            System.out.println(item);
        }
    }

    static ArrayDeque<Integer> deque = new ArrayDeque<>();
    static int[] arr;
    private static int[] Calculate(int[] nums, int k)
    {
        arr = nums;

        int n = arr.length;

        if (n * k == 0) return new int[0];

        if (k == 1) return nums;

        int maxIdx = 0;

        //process less than k in array
        for (int i = 0; i < k; i++) {
            cleanDeque(i, k);
            deque.addLast(i);

            if (arr[i] > maxIdx)
            {
                maxIdx = i;
            }
        }

        int[] output = new int[n - k +1];
        output[0] = nums[maxIdx];

        for (int i = k; i < n; i++) {
            cleanDeque(i, k);
            deque.addLast(i);
            output[i-k+1] = arr[deque.getFirst()];
        }
        return output;
    }

    private static void cleanDeque(int i, int k)
    {
        if (!deque.isEmpty() && deque.getFirst() == i-k)
        {
            deque.removeFirst();
        }

        while (!deque.isEmpty() && arr[i] > arr[deque.getLast()])
        {
            deque.removeLast();
        }
    }
}
