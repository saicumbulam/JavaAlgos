/*
Find the bad version, Search in a peak element array

1. This is a modified binary search.
2. comparison of num[mid]  and target is replaced by num[mid] and num[mid+1]
3. id num[mid] > num[mid+1] => end = mid else start = mid+1
* */
package Leetcode.BinarySearch.Often;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(FindPeak(nums));
    }

    private static int FindPeak(int[] nums) {
        int start = 0, end = nums.length;
        while (start < end) // infinite loop will go if its a <= sign
        {
            int mid = start + (end -start)/2;

            // The mid shld be greater than mid+1
            if (nums[mid] > nums[mid+1])
            {
                end = mid;
            }
            else
            {
                start = mid + 1;
            }
        }

        return start;
    }

    private static int Search(int[] arr, int target)
    {
        int maxElementIdx = FindPeak(arr);
        int index = BinarySearch(arr, 0, maxElementIdx, target);
        if (index == -1)
        {
            index = BinarySearch(arr, maxElementIdx+1, arr.length-1,target);
        }
        return index;
    }

    private static int BinarySearch(int[] arr, int left, int right, int target)
    {
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
