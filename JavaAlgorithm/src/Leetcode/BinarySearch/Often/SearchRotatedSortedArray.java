/*
1. Binary search with ascending and descending detection
2. if ascending:  nums[left] >= nums[mid]
   then if target >= nums[left] && target < nums[mid],
   we can search inside left and mid, by right = mid -1.

* */
package Leetcode.BinarySearch.Often;

public class SearchRotatedSortedArray {


    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        //int[] nums = {10,6,4};
        //int target = 2;
        int target = 10;
        System.out.println(Calculate(nums, target));
    }

    private static int Calculate(int[] nums, int target)
    {
        int left = 0, right = nums.length-1;

        while (left <= right)
        {
            int mid = left + (right - left)/2;

            if(nums[mid] == target)
            {
                return mid;
            }

            if (nums[left] <= nums[mid])
            {
                if (target >= nums[left] && target < nums[mid])
                {
                    right = mid-1;
                }
                else
                {
                    left = mid+1;
                }
            }
            else
            {
                if (target <= nums[right] && target > nums[mid])
                {
                    left = mid+1;
                }
                else
                {
                    right = mid-1;
                }
            }
        }

        return -1;
    }
}
