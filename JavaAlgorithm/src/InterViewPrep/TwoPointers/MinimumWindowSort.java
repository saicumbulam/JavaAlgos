/*
Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.

Input: [1, 2, 5, 3, 7, 10, 9, 12]
Output: 5
Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted

Time: O(N)
space: O(1)
* */
package InterViewPrep.TwoPointers;

public class MinimumWindowSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 7, 10, 9, 12};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr)
    {
        int left = 0, right = arr.length-1;

        while (left < arr.length-1 && arr[left] < arr[left+1])
        {
            left++;
        }

        if (left == arr.length-1)
        {
            return 0;
        }

        while (right >= 0 && arr[right] > arr[right-1])
        {
            right--;
        }

        int subMin = Integer.MAX_VALUE;
        int subMax = Integer.MIN_VALUE;

        for (int i = left; i <= right ; i++) {
            subMin = Math.min(subMin, arr[i]);
            subMax = Math.max(subMax, arr[i]);
        }

        while (left >= 0 && arr[left-1] > subMin)
        {
            left--;
        }

        while (right < arr.length-1 && arr[right+1] < subMax)
        {
            right++;
        }

        return right-left+1;
    }
}
