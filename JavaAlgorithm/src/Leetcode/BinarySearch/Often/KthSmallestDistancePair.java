/*
1. Sort the array
2. Do a sliding binary search.
3. In the binary search, calculate left = 0 and
   right = (nums[nums.length-1] - nums[0])
4. Calculate the count of elements btw left and right that are <= mid
5. adjust the high and low accordingly


This problem also can be solved used PriorityQueue,
but it will fail due to memory issues.
* */
package Leetcode.BinarySearch.Often;

import java.util.Arrays;

public class KthSmallestDistancePair {
    public static void main(String[] args) {
        int[] nums = {1,3,1};
        int k = 1;
        System.out.println(Calculate(nums, k));
    }

    private static int Calculate(int[] nums, int k)
    {
        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length-1] - nums[0];

        while (low < high)
        {
            int mid = low + (high - low)/2;

            int count = 0, left = 0;
            for (int right = 0; right < nums.length; right++) {
                while (nums[right] - nums[left] > mid)
                {
                    left++;
                }
                count += right-left;
            }

            if (count >= k)
            {
                high = mid;
            }
            else
            {
                low = mid+1;
            }
        }
        return low;
    }
}
