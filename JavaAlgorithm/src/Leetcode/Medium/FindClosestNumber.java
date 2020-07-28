/*
run time complexity: o(logn)

Pseudocode:
1. Do a binary search to find the mid.
2. if the mid is not found, return start if ((arr[start] - target) < (target - arr[end])
   else return end
* */
package Leetcode.Medium;

public class FindClosestNumber {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 6, 6, 8, 9 };
        int target = 11;
        System.out.println(closestNumber(arr, target));
    }

    private static int closestNumber(int[] arr, int target) {
        if (target < arr[0])
        {
            return arr[0];
        }
        if (target > arr[arr.length-1])
        {
            return arr[arr.length-1];
        }

        int left = 0, right = arr.length-1;
        while (left <= right)
        {
            int mid = left + (right - left)/2;
            if (arr[mid] == target)
            {
                return arr[mid];
            }

            if (target > arr[mid])
            {
                left = mid+1;
            }
            else
            {
                right = mid-1;
            }
        }

        if ((arr[left] - target) < (target - arr[right]))
        {
            return arr[left];
        }
        return arr[right];
    }

}
