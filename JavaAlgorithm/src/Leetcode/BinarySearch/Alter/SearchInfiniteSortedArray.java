/*
This program will not work, since it requires a ArrayReader to run
* */
package Leetcode.BinarySearch.Alter;

public class SearchInfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[] { 1,2,3,4,5,6,7};
        System.out.println(Calculate(arr, 7));
    }

    private static int Calculate(int[] arr, int target)
    {
        int left = 0, right = 1;
        while (arr[right] < target)
        {
            int nextLeft = right+1;
            int nextRight = (right)* 2;
            left = nextLeft;
            right = nextRight;
        }

        return binarySearch(arr, target);
    }

    private static int binarySearch(int[] arr, int target)
    {
        int left = 0, right = arr.length-1;
        while (left <= right)
        {
            int mid = left + (right - left)/2;

            if (arr[mid] == target)
            {
                return mid;
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

        return -1;
    }
}
