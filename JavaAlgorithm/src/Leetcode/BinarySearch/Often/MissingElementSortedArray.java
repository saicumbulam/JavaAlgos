/*
1. Modified binary search algo
2. Caculate the mid of the start and end of array.
3. calculate missing elements: nums[mid] - nums[0] - mid
4. if (missing >= k) => end = mid - 1 else start = mid + 1
5.  calculate missing element  again at the end using nums[end] - nums[0]-1
6. get the missing element using nums[end] + k - missing
* */
package Leetcode.BinarySearch.Often;

public class MissingElementSortedArray {
    public static void main(String[] args) {
        System.out.println(Calculate(new int[]{1,3,5}, 2));
    }

    public static int Calculate(int[] nums, int k) {
        int left = 0, right = nums.length-1;

        while (left <= right)
        {
            int mid = left + (right - left)/2;

            int missing = nums[mid] - nums[0] - mid;

            if (missing >= k)
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }
        int missing = nums[right] - nums[0] - right;
        return nums[right] + missing - k;
    }
}
