/*
Input: [1, 2, -1, 2, 2]
Output: true
Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0

* */
package InterViewPrep.FastSlow;

public class CycleCircularArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, -1, 2, 2};
        //int[] arr = {2, 1, -1, -2};
        System.out.println(Calculate(arr));
    }

    private static boolean Calculate(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            int slow = i, fast = i;
            boolean isForward = arr[i] >= 0;

            do {
                slow = NextIndex(slow, arr, isForward);
                fast = NextIndex(fast, arr, isForward);
                if (fast != -1)
                {
                    fast = NextIndex(fast, arr, isForward);
                }
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && fast == slow)
            {
                return true;
            }
        }

        return false;
    }

    private static int NextIndex(int index, int[] arr, boolean direction)
    {
        boolean newDirection = arr[index] >= 0;
        if (newDirection != direction)  // detect forward and backward movements
        {
            return -1;
        }

        int nextIndex = index + arr[index];
        nextIndex %= arr.length;
        if (nextIndex < 0)
        {
            nextIndex += arr.length;
        }

        if (nextIndex == index) // detect forward and backward movements
        {
            return -1;
        }

        return nextIndex;
    }
}
