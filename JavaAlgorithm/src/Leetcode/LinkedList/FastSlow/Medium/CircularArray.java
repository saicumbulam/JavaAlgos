/*
Time complexity is O(N^2)
Space is O(1)
* */
package Leetcode.LinkedList.FastSlow.Medium;

public class CircularArray {
    public static void main(String[] args) {
        //int[] arr = new int[] {2,-1,1,2,2};
        int[] arr = new int[] {-1,2};
        System.out.println(Calculate(arr));
    }

    private static boolean Calculate(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            boolean isForward = arr[i] >= 0;
            int slow = i, fast = i;

            do {
                slow = findNextIndex(arr, isForward, slow);
                fast = findNextIndex(arr, isForward, fast);
                if (fast != -1)
                {
                    fast = findNextIndex(arr, isForward, fast);
                }
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && fast == slow)
            {
                return true;
            }
        }
        return false;
    }

    private static int findNextIndex(int[] arr, boolean isForward, int curIdx) {
        boolean direction = arr[curIdx] >= 0;
        if (direction != isForward)
        {
            return -1;
        }

        int nextIdx = (curIdx + arr[curIdx])% arr.length;
        if (nextIdx < 0)
        {
            nextIdx += arr.length;
        }
        if (nextIdx == curIdx)
        {
            return -1;
        }
        return nextIdx;
    }
}
